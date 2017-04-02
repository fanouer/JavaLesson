package org.tedu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.tedu.dao.AdminDao;
import org.tedu.entity.Admin;
import org.tedu.util.MyBatisUtil;

public class TestAdmin {
	@Test
	public void testFindAll() throws Exception{
		SqlSession session = 
			MyBatisUtil.getSession();
		//根据AdminDao接口生成实现对象
		AdminDao dao = 
			session.getMapper(AdminDao.class);
		List<Admin> list = dao.findAll();
		for(Admin admin:list){
			System.out.println(
				admin.getId()+" "
				+admin.getCode());
		}
		session.close();
	}
	
	@Test
	public void testFindByCode() throws Exception{
		SqlSession session = 
			MyBatisUtil.getSession();
		//根据AdminDao接口生成实现对象
		AdminDao dao = 
			session.getMapper(AdminDao.class);
		Admin admin = dao.findByCode("admin");
		if(admin != null){
			System.out.println(admin.getName());
			System.out.println(admin.getTelephone());
		}else{
			System.out.println("用户不存在");
		}
		session.close(); 
	}
}
