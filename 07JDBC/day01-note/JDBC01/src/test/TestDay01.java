package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

import util.DBTool;
import util.DBUtil;

public class TestDay01 {
	
	/**
	 * DBUtil.getConnection()
	 */
	@Test
	public void test6() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			System.out.println(con);
			System.out.println(
				con.getClass().getName());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"创建连接失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 修改员工数据
	 */
	@Test
	public void test5() {
		Connection con = null;
		try {
			con = DBTool.getConnection();
			String sql = 
				"update emps set " +
				"ename='悟空'," +
				"job='保镖',sal=3000.0 " +
				"where empno=7";
			Statement smt = con.createStatement();
			int rows = smt.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"修改员工失败", e);
		} finally {
			DBTool.close(con);
		}
	}
	
	/**
	 * 增加员工数据
	 */
	@Test
	public void test4() {
		Connection con = null;
		try {
			con = DBTool.getConnection();
			//SQL
			String sql = 
				"INSERT INTO emps VALUES(9,'唐僧','领导',1,CURDATE(),4000.0,0,1);";
			//创建Statement
			Statement smt = con.createStatement();
			//执行SQL，返回影响的行数
			int rows = smt.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"增加员工失败", e);
		} finally { 
			DBTool.close(con);
		}
	}
	
	/**
	 * DBTool.getConnection()
	 */
	@Test
	public void test3() {
		Connection con = null;
		try {
			con = DBTool.getConnection();
			System.out.println(con);
			//执行SQL
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"创建连接失败", e);
		} finally {
			DBTool.close(con);
		}
	}

	/**
	 * 读取properties文件
	 */
	@Test
	public void test2() {
		//专门用来读此类文件的工具
		Properties p = new Properties();
		//从项目的classpath下读取文件
		//classpath默认为src，可以改。
		//任何类都有ClassLoader，可以
		//用来从classpath下读取文件。
		try {
			p.load(TestDay01.class
				.getClassLoader()
				.getResourceAsStream(
					"util/db.properties"));
			System.out.println(
				p.getProperty("driver"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建连接
	 */
	@Test
	public void test1() {
		//准备连接参数
		String driver = 
			"com.mysql.jdbc.Driver";
		String url = 
			"jdbc:mysql://localhost:3306/java";
		String user = "root";
		String pwd = "mysql";
		//加载(注册)驱动
		Connection con = null;
		try {
			//执行该类的静态块，Driver类
			//的静态块中进行了自我注册。
			//即告诉DriverManager用我创建连接。
			Class.forName(driver);
			//创建连接
			con = DriverManager
				.getConnection(url, user, pwd);
			System.out.println(con);
			System.out.println(
				con.getClass().getName());
		} catch (ClassNotFoundException e) {
			//异常处理：
			//1.记录日志(Log4j)
			e.printStackTrace();
			//2.解决：返回默认值
			//3.上报：让调用方解决
			throw new RuntimeException(
				"无法加载驱动类", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"执行SQL失败", e);
		} finally {
			//无论如何都要尝试关闭连接
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(
						"关闭连接失败", e);
				}
			}
		}
	}
	
}







