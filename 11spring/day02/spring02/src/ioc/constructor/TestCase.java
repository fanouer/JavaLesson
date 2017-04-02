package ioc.constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	@Test
	//≤‚ ‘ππ‘Ï∆˜◊¢»Î
	public void test1(){
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"ioc/constructor/applicationContext.xml");
	A a = ac.getBean("a1",A.class);
	a.execute();
	}
	
	
	
	
	
	
}
