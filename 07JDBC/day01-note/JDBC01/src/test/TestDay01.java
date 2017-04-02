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
				"��������ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * �޸�Ա������
	 */
	@Test
	public void test5() {
		Connection con = null;
		try {
			con = DBTool.getConnection();
			String sql = 
				"update emps set " +
				"ename='���'," +
				"job='����',sal=3000.0 " +
				"where empno=7";
			Statement smt = con.createStatement();
			int rows = smt.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"�޸�Ա��ʧ��", e);
		} finally {
			DBTool.close(con);
		}
	}
	
	/**
	 * ����Ա������
	 */
	@Test
	public void test4() {
		Connection con = null;
		try {
			con = DBTool.getConnection();
			//SQL
			String sql = 
				"INSERT INTO emps VALUES(9,'��ɮ','�쵼',1,CURDATE(),4000.0,0,1);";
			//����Statement
			Statement smt = con.createStatement();
			//ִ��SQL������Ӱ�������
			int rows = smt.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"����Ա��ʧ��", e);
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
			//ִ��SQL
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"��������ʧ��", e);
		} finally {
			DBTool.close(con);
		}
	}

	/**
	 * ��ȡproperties�ļ�
	 */
	@Test
	public void test2() {
		//ר�������������ļ��Ĺ���
		Properties p = new Properties();
		//����Ŀ��classpath�¶�ȡ�ļ�
		//classpathĬ��Ϊsrc�����Ըġ�
		//�κ��඼��ClassLoader������
		//������classpath�¶�ȡ�ļ���
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
	 * ��������
	 */
	@Test
	public void test1() {
		//׼�����Ӳ���
		String driver = 
			"com.mysql.jdbc.Driver";
		String url = 
			"jdbc:mysql://localhost:3306/java";
		String user = "root";
		String pwd = "mysql";
		//����(ע��)����
		Connection con = null;
		try {
			//ִ�и���ľ�̬�飬Driver��
			//�ľ�̬���н���������ע�ᡣ
			//������DriverManager���Ҵ������ӡ�
			Class.forName(driver);
			//��������
			con = DriverManager
				.getConnection(url, user, pwd);
			System.out.println(con);
			System.out.println(
				con.getClass().getName());
		} catch (ClassNotFoundException e) {
			//�쳣����
			//1.��¼��־(Log4j)
			e.printStackTrace();
			//2.���������Ĭ��ֵ
			//3.�ϱ����õ��÷����
			throw new RuntimeException(
				"�޷�����������", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"ִ��SQLʧ��", e);
		} finally {
			//������ζ�Ҫ���Թر�����
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(
						"�ر�����ʧ��", e);
				}
			}
		}
	}
	
}







