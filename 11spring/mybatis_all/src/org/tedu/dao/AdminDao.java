package org.tedu.dao;

import java.util.List;

import org.tedu.entity.Admin;

public interface AdminDao {
	public List<Admin> findAll();
	public Admin findByCode(String code);
}
