package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Emp;
@Repository("empDAO")
public class EmpDAO {
	@Resource(name="jt")
	private JdbcTemplate jt;
	
	/**
	 * update����:����������,�޸ĺ�ɾ��������
	 * �ڶ�������Ҫ����һ����������(object[]),
	 * �����е�Ԫ���� ? һһ��Ӧ��
	 * 
	 * jdbcTempate�Ὣ�ײ���쳣ͳһת����
	 * spring�쳣���ͣ�Ȼ���׳���
	 */
	public void add(Emp emp){
		String sql = 
			"INSERT INTO emp_czh1 " +
			"VALUES(emp_czh1_seq.nextval,?,?)";
		jt.update(sql, 
				new Object[]{emp.getName(),
				emp.getAge()});
	}
	
	public List<Emp> findAll(){
		List<Emp> emps = 
			new ArrayList<Emp>();
		String sql = "SELECT * FROM emp_czh1";
		emps = jt.query(sql, new EmpRowMapper());
		return emps;
	}
	
	public Emp findById(int id){
		Emp emp = null;
		String sql = "SELECT * FROM emp_czh1 " +
				"WHERE id=?";
		emp = jt.queryForObject(sql, 
				new EmpRowMapper(),
				new Object[]{id});
		return emp;
	}
	
	/*
	 * ���û�з��������ļ�¼ queryForObject
	 * �����ᱨ�쳣�����Բ鿴findById2�Ĵ���
	 */
	public Emp findById2(int id){
		Emp emp = null;
		String sql = "SELECT * FROM emp_czh1 " +
				"WHERE id=?";
		List<Emp> emps = 
			jt.query(sql, new Object[]{id},
					new EmpRowMapper());
		if(emps != null  && emps.size() > 0){
			emp = emps.get(0);
		}
		return emp;
	}
	
	
	public void update(Emp emp){
		String sql = "UPDATE emp_czh1 " +
				"SET name=?,age=? WHERE id=?";
		jt.update(sql, 
				new Object[]{emp.getName(),
				emp.getAge(),emp.getId()});
	}
	
	public void delete(int id){
		String sql = 
			"DELETE FROM emp_czh1 WHERE id=?";
		jt.update(sql, new Object[]{id});
	}
	
	//�����ܵļ�¼��
	public int getRows(){
		String sql = "SELECT count(*) " +
				"FROM emp_czh1";
		return jt.queryForObject(sql,
				Integer.class);
	}
	
	/*
	 * jdbcTemplate����ͨ��RowMapper��������֪
	 * ��ν�ResultSet�еļ�¼ת������Ӧ��
	 * java����(����Emp����)��
	 */
	class EmpRowMapper implements RowMapper<Emp>{

		/*
		 * index:���ڱ������ļ�¼���±꣬��
		 * 0��ʼ��
		 */
		public Emp mapRow(ResultSet rst, 
				int index) throws SQLException {
			Emp emp = new Emp();
			emp.setId(rst.getInt("id"));
			emp.setName(rst.getString("name"));
			emp.setAge(rst.getInt("age"));
			return emp;
		}
		
	}
	
	
	
	
	
	
	
	
}
