package dao;

import java.util.List;

import entity.Emp;

public interface EmpDao {
	
	List<Emp> findAll();
	
	void save(Emp e);

}





