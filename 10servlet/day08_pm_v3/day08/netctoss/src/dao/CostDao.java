package dao;

import java.util.List;

import entity.Cost;

public interface CostDao {
	
	List<Cost> findAll();

	void save(Cost cost);
	
	Cost findById(int id);
	
	void update(Cost cost);
	
	/**
	 * ��ҳ��ѯ�ʷ�
	 * @param page ��ǰ��ҳ��
	 * @param size ÿҳ��ʾ������
	 */
	List<Cost> findByPage(int page, int size);
	
	int findRows();
	
}








