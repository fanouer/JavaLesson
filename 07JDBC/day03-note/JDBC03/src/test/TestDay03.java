package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.EmpDao;
import dao.EmpDaoImpl;
import entity.Emp;

import util.DBUtil;

public class TestDay03 {
	
	/**
	 * EmpDao.findById()
	 * EmpDao.update()
	 */
	@Test
	public void test6() {
		EmpDao dao = new EmpDaoImpl();
		//假设用户要查询此ID对应的数据
		int id = 121;
		Emp emp = dao.findById(id);
		//在此输出测试该数据
		
		//假设用户修改了此数据
		emp.setEname("");
		emp.setSal(0.0);
		dao.update(emp);
	}
	
	/**
	 * EmpDao.save()
	 */
	@Test
	public void test5() {
		//模拟用户传入的数据
		Emp e = new Emp();
		e.setEname("诸葛亮");
		e.setJob("军师");
		e.setMgr(120);
		e.setHiredate(new Date(
			System.currentTimeMillis()));
		e.setSal(6000.0);
		e.setDeptno(1);
		
		EmpDao dao = new EmpDaoImpl();
		dao.save(e);
	}
	
	/**
	 * CostDao.findAll()
	 */
	@Test
	public void test4() {
		EmpDao dao = new EmpDaoImpl();
		List<Emp> list = dao.findAll();
		for(Emp e : list) {
			System.out.println(
				e.getEmpno() + "," +
				e.getEname());
		}
	}
	
	/**
	 * 分页查询员工数据
	 */
	@Test
	public void test3() {
		//假设需求要求每页显示10行
		int size = 10;
		//假设当前用户点了第2页
		int page = 2;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from (" +
				"	select e.*,rownum r from (" +
				"		select * from emps_lhh " +
				"		order by empno" +
				"	) e" +
				") where r between ? and ?";
			System.out.println(sql);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//起始行=(page-1)*size+1
			int begin = (page-1)*size+1;
			//终止行=page*size
			int end = page*size;
			ps.setInt(1, begin);
			ps.setInt(2, end);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(
					rs.getInt("empno"));
				System.out.println(
					rs.getString("ename"));
				System.out.println(
					rs.getDouble("sal"));
				System.out.println("---------");
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
	 * 返回自动生成的主键：
	 * 1.添加部门
	 * 2.返回部门ID
	 * 3.添加员工，使用部门ID
	 */
	@Test
	public void test2() {
		//假设用户传入了如下的数据
		//部门数据
		String dname = "财务部";
		String loc = "南京";
		//员工数据
		String ename = "刘备";
		String job = "皇叔";
		int mgr = 0;
		Date hiredate = new Date(
			System.currentTimeMillis());
		double sal = 8000.0;
		double comm = 5000.0;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			//1.增加部门
			String sql = 
				"insert into depts_lhh " +
				"values(depts_seq_lhh.nextval,?,?)";
			//参数2是一个数组，存需要ps记录的字段名
			PreparedStatement ps = 
				con.prepareStatement(
					sql, new String[]{"deptno"});
			ps.setString(1, dname);
			ps.setString(2, loc);
			ps.executeUpdate();
			//2.获取部门ID
			//结果集中存的是ps记录的字段的值
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int deptno = rs.getInt(1);
			//3.增加员工
			sql = "insert into emps_lhh values(" +
				"emps_seq_lhh.nextval,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, ename);
			ps.setString(2, job);
			ps.setInt(3, mgr);
			ps.setDate(4, hiredate);
			ps.setDouble(5, sal);
			ps.setDouble(6, comm);
			ps.setInt(7, deptno);
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(
					"回滚失败", e);
			}
			e.printStackTrace();
			throw new RuntimeException(
				"增加部门和员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 批量添加数据：
	 * 1.添加108个员工。
	 * 2.每次添加20个。
	 */
	@Test
	public void test1() {
		//应该传入108个员工，但太多无法模拟，
		//就简单的循环108次，给出相同的数据。
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			//手动提交事务
			con.setAutoCommit(false);
			//只有SQL相同，才能批量添加
			String sql = 
				"insert into emps_lhh values(" +
				"emps_seq_lhh.nextval," +
				"?,?,?,?,?,?,?)";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//模拟遍历108条数据
			for(int i=0;i<108;i++) {
				//将本条员工数据存入ps
				ps.setString(1, "好汉"+i);
				ps.setString(2, "打劫");
				ps.setInt(3, 0);
				ps.setDate(4, new Date(
					System.currentTimeMillis()));
				ps.setDouble(5, 2000.0);
				ps.setDouble(6, 300.0);
				ps.setInt(7, 2);
				ps.addBatch();
				//每20次提交一次数据库
				if(i%20 == 0) {
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			//对剩余的数据提交一次数据库
			ps.executeBatch();
			//提交事务
			con.commit();
		} catch (SQLException e) {
			//回滚事务
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(
					"回滚事务失败", e);
			}
			e.printStackTrace();
			throw new RuntimeException(
				"批量添加员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}

}









