package container.instatiation;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类(使用了junit测试框架)
 */
public class TestCase {
	@Test
	public void test1(){
		//启动spring容器
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"container/instatiation" +
	"/applicationContext.xml");
		//通过容器获得对象
		ExampleBean eb1 = 
			ac.getBean("eb1",ExampleBean.class);
		System.out.println(eb1);
	}
	
	@Test
	//测试静态工厂方法创建对象
	public void test2(){
		//启动spring容器
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"container/instatiation" +
	"/applicationContext.xml");
		//通过容器获得对象
		Calendar cal1 = 
			ac.getBean("cal1",Calendar.class);
		System.out.println(cal1);
	}
	
	@Test
	//测试实例工厂方法创建对象
	public void test3(){
		//启动spring容器
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"container/instatiation" +
	"/applicationContext.xml");
		//通过容器获得对象
		Calendar cal = 
			ac.getBean("cal2",Calendar.class);
		System.out.println(cal);
		Date date1 = 
			ac.getBean("date1",Date.class);
		System.out.println(date1);
	}
	
	
	
	
	
	
	
}
