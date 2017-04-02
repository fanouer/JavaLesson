package ioc.resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	@Test
	public void test1(){
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
		"ioc/resource/applicationContext.xml");
		Manager mg = 
			ac.getBean("mg",Manager.class);
		System.out.println(mg);
		
	}
	
	
	
	
	
}
