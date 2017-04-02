package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import entity.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Emp> findAll() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from emps_lhh " +
				"order by empno";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//�������������ÿһ�����ݷ�װ��
			//һ��Emp������List��
			List<Emp> list = new ArrayList<Emp>();
			while(rs.next()) {
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getDate("hiredate"));
				e.setSal(rs.getDouble("sal"));
				e.setComm(rs.getDouble("comm"));
				e.setDeptno(rs.getInt("deptno"));
				list.add(e);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"��ѯԱ��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public Emp findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Emp emp) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"insert into emps_lhh values(" +
				"emps_seq_lhh.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//setInt/setDouble���ܴ���null��
			//���ǿ��ܱ��������ǿ���Ϊnull�ġ�
			//��������������Խ��䵱��Object����
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setObject(3, emp.getMgr());
			ps.setDate(4, emp.getHiredate());
			ps.setObject(5, emp.getSal());
			ps.setObject(6, emp.getComm());
			ps.setObject(7, emp.getDeptno());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"���Ա��ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
	}

	@Override
	public void update(Emp emp) {
		// TODO Auto-generated method stub

	}

}
