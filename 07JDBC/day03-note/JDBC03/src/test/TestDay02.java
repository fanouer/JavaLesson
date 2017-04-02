package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.DBUtil;

public class TestDay02 {
	
	/**
	 * 模拟转账的业务：
	 * 1.理解在业务内如何使用JDBC
	 * 2.有一个需要处理的问题
	 */
	@Test
	public void test10() {
		//假设张三已经登录，并输入了
		//收款方账号以及要转账的金额
		//支出方账号
		String payId = "00001";
		//收款方账号
		String recId = "00002";
		//转账金额
		double mny = 1000.0;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			//1.查询支出方余额
			String sql = 
				"select * from accounts_lhh " +
				"where id=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, payId);
			ResultSet rs = ps.executeQuery();
			double money = 0;
			if(rs.next()) {
				money = rs.getDouble("money");
				if(money<mny) {
					System.out.println("余额不足");
					return;
				}
			}
			//2.查询收款方账号
			//该SQL与查询支付账号的一样，可以不写
			sql = "select * from accounts_lhh " +
				  "where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, recId);
			rs = ps.executeQuery();
			if(!rs.next()) {
				System.out.println("收款账号错误");
				return;
			}
			//上面的if里已经next过了
			double recMoney = rs.getDouble("money");
			
			//JDBC默认自动提交事务
			//因为3、4步是一套完整的业务，
			//应该处于一个事务范围内，
			//所以此处应该改为手动提交事务
			con.setAutoCommit(false);
			
			//3.更新支出方的余额(-1000)
			sql = "update accounts_lhh " +
				  "set money=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, money-mny);
			ps.setString(2, payId);
			ps.executeUpdate();
			
			//假设程序运行到此处断电了；
			//假设此处有一个很隐晦的BUG；
			Integer.valueOf("abc");
			
			//4.更新收款方的余额(+1000)
			sql = "update accounts_lhh " +
				  "set money=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, recMoney+mny);
			ps.setString(2, recId);
			ps.executeUpdate();
			
			//当3、4步都成功时，才提交事务
			con.commit();
		} catch (Exception e) {
			//一旦发生异常，则回滚事务
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(
					"回滚失败", e);
			}
			e.printStackTrace();
			throw new RuntimeException(
				"转账失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * ResultSetMetaData(了解)
	 */
	@Test
	public void test9() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from emps_lhh";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//获取结果集的元数据，即
			//获取结果集的描述信息。
			ResultSetMetaData md = 
				rs.getMetaData();
			//输出元数据中的一些内容
			System.out.println(
				md.getColumnCount());
			System.out.println(
				md.getColumnName(1));
			System.out.println(
				md.getColumnClassName(1));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 使用PreparedStatement解决注入攻击
	 */
	@Test
	public void test8() {
		//假设用户登录时传入的参数如下
		String user = "tom";
		String pwd = "a' or 'b'='b";
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from users_lhh " +
				"where username=? " +
				"and password=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("登录成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询用户失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 注入式攻击：
	 * 使用Statement执行查询存在的漏洞。
	 */
	@Test
	public void test7() {
		//假设用户登录时传入的参数如下
		String user = "tom";
		String pwd = "a' or 'b'='b";
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from users_lhh " +
				"where username='"+user+"' " +
				"and password='"+pwd+"'";
			Statement smt = 
				con.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("登录成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询用户失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * PreparedStatement之删除
	 */
	@Test
	public void test6() {
		//假设传入了要删除数据
		int id = 11;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"delete from emps_lhh " +
				"where empno=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"删除员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * PreparedStatement之修改
	 */
	@Test
	public void test5() {
		//假设传入了修改后的数据
		int empno = 11;
		String ename = "沙僧";
		String job = "挑担子";
		double sal = 1000.0;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"update emps_lhh set " +
				"ename=?,job=?,sal=? " +
				"where empno=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, ename);
			ps.setString(2, job);
			ps.setDouble(3, sal);
			ps.setInt(4, empno);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"修改员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * PreparedStatement之增加
	 */
	@Test
	public void test4() {
		//假设传入了要增加的数据
		String ename = "八戒";
		String job = "职员";
		int mgr = 0;
		//java.sql.Date
		Date hiredate = new Date(
			System.currentTimeMillis());
		double sal = 3000.0;
		double comm = 1000.0;
		int deptno = 1;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"insert into emps_lhh " +
				"values(emps_seq_lhh.nextval," +
				"?,?,?,?,?,?,?)";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, ename);
			ps.setString(2, job);
			ps.setInt(3, mgr);
			ps.setDate(4, hiredate);
			ps.setDouble(5, sal);
			ps.setDouble(6, comm);
			ps.setInt(7, deptno);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"增加员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * PreparedStatement之查询
	 * 查询工资高于4000的员工(sal>4000)
	 */
	@Test
	public void test3() {
		//假设传入了工资条件
		double sal = 4000.0;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from emps_lhh " +
				"where sal>?";
			//创建PreparedStatement，传入SQL，
			//它会发送SQL，由DB创建执行计划。
			//此过程也叫预编译SQL。
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//传入参数
			//ps.set类型(?的下标,?的值)
			ps.setDouble(1, sal);
			//执行SQL
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(
					rs.getString("ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 根据部门ID查询员工
	 */
	@Test
	public void test2() {
		//假设传入了部门ID
		int deptId = 1;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from emps_lhh " +
				"where deptno=" + deptId;
			Statement smt = con.createStatement();
			//返回的结果集中包含多行多列数据，
			//该对象采用了迭代器模式，因此可以
			//直接while遍历，每次遍历将得到一行
			//数据，再调用方法从这一行中取某列数据。
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(
					rs.getInt("empno"));
				System.out.println(
					rs.getString("ename"));
				System.out.println(
					rs.getDate("hiredate"));
				System.out.println(
					rs.getDouble("sal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询员工失败", e);
		} finally {
			DBUtil.close(con);
		}
		
	}
	
	/**
	 * 根据ID删除员工
	 */
	@Test
	public void test1() {
		//假设传入的id
		int id = 9;
		//创建连接
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"delete from emps_lhh " +
				"where empno=" + id;
			//执行SQL
			Statement smt = con.createStatement();
			smt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"删除员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}

}








