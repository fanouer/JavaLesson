package com.tarena.oss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.oss.dao.AdminDAO;
import com.tarena.oss.entity.Admin;
/**
 * ҵ���ʵ��
 *
 */
@Service("adminService")
public class AdminServiceImpl 
implements AdminService{
	@Resource(name="adminDAO")
	private AdminDAO adminDAO; 
	public Admin checkLogin(
			String code, String pwd) {
		//�����ʺŲ�ѯ���ݿ�
		Admin admin = 
			adminDAO.findByCode(code);
		if(admin == null){
			//�Ҳ���,�׳�һ��Ӧ���쳣
			throw new ApplicationException(
					"�ʺŴ���");
		}
		if(!admin.getPassword().equals(pwd)){
			//�������,�׳�һ��Ӧ���쳣
			throw new ApplicationException(
					"�������");
		}
		//��¼�ɹ�
		return admin;
	}

}
