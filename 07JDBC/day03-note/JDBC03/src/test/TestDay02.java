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
	 * ģ��ת�˵�ҵ��
	 * 1.�����ҵ�������ʹ��JDBC
	 * 2.��һ����Ҫ���������
	 */
	@Test
	public void test10() {
		//���������Ѿ���¼����������
		//�տ�˺��Լ�Ҫת�˵Ľ��
		//֧�����˺�
		String payId = "00001";
		//�տ�˺�
		String recId = "00002";
		//ת�˽��
		double mny = 1000.0;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			//1.��ѯ֧�������
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
					System.out.println("����");
					return;
				}
			}
			//2.��ѯ�տ�˺�
			//��SQL���ѯ֧���˺ŵ�һ�������Բ�д
			sql = "select * from accounts_lhh " +
				  "where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, recId);
			rs = ps.executeQuery();
			if(!rs.next()) {
				System.out.println("�տ��˺Ŵ���");
				return;
			}
			//�����if���Ѿ�next����
			double recMoney = rs.getDouble("money");
			
			//JDBCĬ���Զ��ύ����
			//��Ϊ3��4����һ��������ҵ��
			//Ӧ�ô���һ������Χ�ڣ�
			//���Դ˴�Ӧ�ø�Ϊ�ֶ��ύ����
			con.setAutoCommit(false);
			
			//3.����֧���������(-1000)
			sql = "update accounts_lhh " +
				  "set money=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, money-mny);
			ps.setString(2, payId);
			ps.executeUpdate();
			
			//����������е��˴��ϵ��ˣ�
			//����˴���һ�������޵�BUG��
			Integer.valueOf("abc");
			
			//4.�����տ�����(+1000)
			sql = "update accounts_lhh " +
				  "set money=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, recMoney+mny);
			ps.setString(2, recId);
			ps.executeUpdate();
			
			//��3��4�����ɹ�ʱ�����ύ����
			con.commit();
		} catch (Exception e) {
			//һ�������쳣����ع�����
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(
					"�ع�ʧ��", e);
			}
			e.printStackTrace();
			throw new RuntimeException(
				"ת��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * ResultSetMetaData(�˽�)
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
			//��ȡ�������Ԫ���ݣ���
			//��ȡ�������������Ϣ��
			ResultSetMetaData md = 
				rs.getMetaData();
			//���Ԫ�����е�һЩ����
			System.out.println(
				md.getColumnCount());
			System.out.println(
				md.getColumnName(1));
			System.out.println(
				md.getColumnClassName(1));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"��ѯԱ��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * ʹ��PreparedStatement���ע�빥��
	 */
	@Test
	public void test8() {
		//�����û���¼ʱ����Ĳ�������
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
				System.out.println("��¼�ɹ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"��ѯ�û�ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * ע��ʽ������
	 * ʹ��Statementִ�в�ѯ���ڵ�©����
	 */
	@Test
	public void test7() {
		//�����û���¼ʱ����Ĳ�������
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
				System.out.println("��¼�ɹ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"��ѯ�û�ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * PreparedStatement֮ɾ��
	 */
	@Test
	public void test6() {
		//���贫����Ҫɾ������
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
				"ɾ��Ա��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * PreparedStatement֮�޸�
	 */
	@Test
	public void test5() {
		//���贫�����޸ĺ������
		int empno = 11;
		String ename = "ɳɮ";
		String job = "������";
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
				"�޸�Ա��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * PreparedStatement֮����
	 */
	@Test
	public void test4() {
		//���贫����Ҫ���ӵ�����
		String ename = "�˽�";
		String job = "ְԱ";
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
				"����Ա��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * PreparedStatement֮��ѯ
	 * ��ѯ���ʸ���4000��Ա��(sal>4000)
	 */
	@Test
	public void test3() {
		//���贫���˹�������
		double sal = 4000.0;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from emps_lhh " +
				"where sal>?";
			//����PreparedStatement������SQL��
			//���ᷢ��SQL����DB����ִ�мƻ���
			//�˹���Ҳ��Ԥ����SQL��
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//�������
			//ps.set����(?���±�,?��ֵ)
			ps.setDouble(1, sal);
			//ִ��SQL
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(
					rs.getString("ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"��ѯԱ��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * ���ݲ���ID��ѯԱ��
	 */
	@Test
	public void test2() {
		//���贫���˲���ID
		int deptId = 1;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from emps_lhh " +
				"where deptno=" + deptId;
			Statement smt = con.createStatement();
			//���صĽ�����а������ж������ݣ�
			//�ö�������˵�����ģʽ����˿���
			//ֱ��while������ÿ�α������õ�һ��
			//���ݣ��ٵ��÷�������һ����ȡĳ�����ݡ�
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
				"��ѯԱ��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
		
	}
	
	/**
	 * ����IDɾ��Ա��
	 */
	@Test
	public void test1() {
		//���贫���id
		int id = 9;
		//��������
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"delete from emps_lhh " +
				"where empno=" + id;
			//ִ��SQL
			Statement smt = con.createStatement();
			smt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"ɾ��Ա��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}

}








