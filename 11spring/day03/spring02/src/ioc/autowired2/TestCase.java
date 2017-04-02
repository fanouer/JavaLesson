package ioc.autowired2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	@Test
	public void test1(){
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
		"ioc/autowired2/applicationContext.xml");
		Restaurant rest = 
			ac.getBean("rest",Restaurant.class);
		System.out.println(rest);
		
	}
	
	
	
	
	
}
