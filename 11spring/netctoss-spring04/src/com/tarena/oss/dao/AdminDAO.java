package com.tarena.oss.dao;

import com.tarena.oss.entity.Admin;
/**
 * 	DAO�ӿڡ�
 *	��Ҫ�漰�κξ�������ݿ���ʼ�����
 */
public interface AdminDAO {
	public Admin findByCode(String code);
}
