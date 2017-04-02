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
		//�����û�Ҫ��ѯ��ID��Ӧ������
		int id = 121;
		Emp emp = dao.findById(id);
		//�ڴ�������Ը�����
		
		//�����û��޸��˴�����
		emp.setEname("");
		emp.setSal(0.0);
		dao.update(emp);
	}
	
	/**
	 * EmpDao.save()
	 */
	@Test
	public void test5() {
		//ģ���û����������
		Emp e = new Emp();
		e.setEname("�����");
		e.setJob("��ʦ");
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
	 * ��ҳ��ѯԱ������
	 */
	@Test
	public void test3() {
		//��������Ҫ��ÿҳ��ʾ10��
		int size = 10;
		//���赱ǰ�û����˵�2ҳ
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
			//��ʼ��=(page-1)*size+1
			int begin = (page-1)*size+1;
			//��ֹ��=page*size
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
				"��ѯԱ��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * �����Զ����ɵ�������
	 * 1.��Ӳ���
	 * 2.���ز���ID
	 * 3.���Ա����ʹ�ò���ID
	 */
	@Test
	public void test2() {
		//�����û����������µ�����
		//��������
		String dname = "����";
		String loc = "�Ͼ�";
		//Ա������
		String ename = "����";
		String job = "����";
		int mgr = 0;
		Date hiredate = new Date(
			System.currentTimeMillis());
		double sal = 8000.0;
		double comm = 5000.0;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			//1.���Ӳ���
			String sql = 
				"insert into depts_lhh " +
				"values(depts_seq_lhh.nextval,?,?)";
			//����2��һ�����飬����Ҫps��¼���ֶ���
			PreparedStatement ps = 
				con.prepareStatement(
					sql, new String[]{"deptno"});
			ps.setString(1, dname);
			ps.setString(2, loc);
			ps.executeUpdate();
			//2.��ȡ����ID
			//������д����ps��¼���ֶε�ֵ
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int deptno = rs.getInt(1);
			//3.����Ա��
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
					"�ع�ʧ��", e);
			}
			e.printStackTrace();
			throw new RuntimeException(
				"���Ӳ��ź�Ա��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * ����������ݣ�
	 * 1.���108��Ա����
	 * 2.ÿ�����20����
	 */
	@Test
	public void test1() {
		//Ӧ�ô���108��Ա������̫���޷�ģ�⣬
		//�ͼ򵥵�ѭ��108�Σ�������ͬ�����ݡ�
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			//�ֶ��ύ����
			con.setAutoCommit(false);
			//ֻ��SQL��ͬ�������������
			String sql = 
				"insert into emps_lhh values(" +
				"emps_seq_lhh.nextval," +
				"?,?,?,?,?,?,?)";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//ģ�����108������
			for(int i=0;i<108;i++) {
				//������Ա�����ݴ���ps
				ps.setString(1, "�ú�"+i);
				ps.setString(2, "���");
				ps.setInt(3, 0);
				ps.setDate(4, new Date(
					System.currentTimeMillis()));
				ps.setDouble(5, 2000.0);
				ps.setDouble(6, 300.0);
				ps.setInt(7, 2);
				ps.addBatch();
				//ÿ20���ύһ�����ݿ�
				if(i%20 == 0) {
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			//��ʣ��������ύһ�����ݿ�
			ps.executeBatch();
			//�ύ����
			con.commit();
		} catch (SQLException e) {
			//�ع�����
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(
					"�ع�����ʧ��", e);
			}
			e.printStackTrace();
			throw new RuntimeException(
				"�������Ա��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}

}









