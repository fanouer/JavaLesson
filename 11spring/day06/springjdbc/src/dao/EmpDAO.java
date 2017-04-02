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
	 * update方法:可以完成添加,修改和删除操作。
	 * 第二个参数要求是一个对象数组(object[]),
	 * 数组中的元素与 ? 一一对应。
	 * 
	 * jdbcTempate会将底层的异常统一转换成
	 * spring异常类型，然后抛出。
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
	 * 如果没有符合条件的记录 queryForObject
	 * 方法会报异常。可以查看findById2的处理。
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
	
	//返回总的记录数
	public int getRows(){
		String sql = "SELECT count(*) " +
				"FROM emp_czh1";
		return jt.queryForObject(sql,
				Integer.class);
	}
	
	/*
	 * jdbcTemplate对象通过RowMapper对象来获知
	 * 如何将ResultSet中的记录转换成相应的
	 * java对象(比如Emp对象)。
	 */
	class EmpRowMapper implements RowMapper<Emp>{

		/*
		 * index:正在被遍历的记录的下标，从
		 * 0开始。
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
