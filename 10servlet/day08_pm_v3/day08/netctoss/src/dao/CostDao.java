package dao;

import java.util.List;

import entity.Cost;

public interface CostDao {
	
	List<Cost> findAll();

	void save(Cost cost);
	
	Cost findById(int id);
	
	void update(Cost cost);
	
	/**
	 * 分页查询资费
	 * @param page 当前的页码
	 * @param size 每页显示的行数
	 */
	List<Cost> findByPage(int page, int size);
	
	int findRows();
	
}








