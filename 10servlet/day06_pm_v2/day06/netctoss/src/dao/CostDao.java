package dao;

import java.util.List;

import entity.Cost;

public interface CostDao {
	
	List<Cost> findAll();

	void save(Cost cost);
	
	Cost findById(int id);
	
}








