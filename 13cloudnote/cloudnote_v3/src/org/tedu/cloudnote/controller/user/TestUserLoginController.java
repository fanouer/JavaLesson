package org.tedu.cloudnote.controller.user;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tedu.cloudnote.util.NoteResult;

public class TestUserLoginController {
	@Test
	public void test1(){
		String[] conf = {"spring-mvc.xml",
			"spring-mybatis.xml"};
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(conf);
		UserLoginController controller = ac.getBean(
			"loginController",UserLoginController.class);
		NoteResult result = 
			controller.execute("demo", "c8837b23ff8aaa8a2dde915473ce0991");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
	}
	
}



