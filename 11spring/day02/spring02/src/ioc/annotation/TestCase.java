package ioc.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	@Test
	public void test1(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
	"ioc/annotation/applicationContext.xml");
		DemoBean db = 
			ac.getBean("db",DemoBean.class);
		System.out.println(db);
	}
	
	@Test
	public void test2(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
	"ioc/annotation/applicationContext.xml");
		DemoBean db = 
			ac.getBean("db",DemoBean.class);
		DemoBean db2 = 
			ac.getBean("db",DemoBean.class);
		System.out.println(db == db2);
	}
	
	@Test
	//测试生命周期相关的方法
	public void test3(){
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
	"ioc/annotation/applicationContext.xml");
		DemoBean db = 
			ac.getBean("db",DemoBean.class);
		System.out.println(db);
		ac.close();
	}
	
	
	
	
	
	
	
	
}
