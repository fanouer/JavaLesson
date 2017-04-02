package com.tarena.oss.dao;

import com.tarena.oss.entity.Admin;
/**
 * 	DAO接口。
 *	不要涉及任何具体的数据库访问技术。
 */
public interface AdminDAO {
	public Admin findByCode(String code);
}
