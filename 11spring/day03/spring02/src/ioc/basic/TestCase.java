package ioc.basic;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	@Test
	public void test1(){
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"ioc/basic/applicationContext.xml");
	Student stu = ac.getBean("stu2",Student.class);
	System.out.println(stu);
		
	}
	
	
	@Test
	public void test2(){
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"ioc/basic/applicationContext.xml");
	System.out.println(
			ac.getBean("dbInfo"));
	}
	
	@Test
	public void test3(){
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"ioc/basic/applicationContext.xml");
	ExampleBean eb = 
		ac.getBean("eb",ExampleBean.class);
	System.out.println(eb);
	}
	
	
	
	
	
	
}
