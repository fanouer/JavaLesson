package dao;

import java.util.List;

import entity.Emp;

public interface EmpDao {

	List<Emp> findAll();
	
	Emp findById(int id);
	
	/**
	 * 新增员工
	 */
	void save(Emp emp);
	
	void update(Emp emp);
	
	void delete(int id);
	
}






