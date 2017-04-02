package com.tarena.oss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.oss.dao.AdminDAO;
import com.tarena.oss.entity.Admin;
/**
 * 业务层实现
 *
 */
@Service("adminService")
public class AdminServiceImpl 
implements AdminService{
	@Resource(name="adminDAO")
	private AdminDAO adminDAO; 
	public Admin checkLogin(
			String code, String pwd) {
		//依据帐号查询数据库
		Admin admin = 
			adminDAO.findByCode(code);
		if(admin == null){
			//找不到,抛出一个应用异常
			throw new ApplicationException(
					"帐号错误");
		}
		if(!admin.getPassword().equals(pwd)){
			//密码错误,抛出一个应用异常
			throw new ApplicationException(
					"密码错误");
		}
		//登录成功
		return admin;
	}

}
