package dao;

import entity.Admin;

public interface AdminDao {
	
	/**
	 * 根据账号查询管理员
	 */
	Admin findByCode(String code);

}





