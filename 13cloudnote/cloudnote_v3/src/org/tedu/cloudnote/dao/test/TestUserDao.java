package org.tedu.cloudnote.dao.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tedu.cloudnote.dao.UserDao;
import org.tedu.cloudnote.entity.User;

public class TestUserDao {
	@Test
	public void test1(){
		String conf = "spring-mybatis.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean(
			"userDao",UserDao.class);
		User user = dao.findByName("demo");
		if(user==null){
			System.out.println("用户不存在");
		}else{
			System.out.println(user.getCn_user_password());
		}
	} 
}
