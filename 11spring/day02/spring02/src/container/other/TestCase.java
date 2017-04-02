package container.other;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 *
 */
public class TestCase {
	@Test
	//测试作用域
	public void test1(){
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"container/other/applicationContext.xml");
	MessageBean mb1 = 
		ac.getBean("mb1",MessageBean.class);
	MessageBean mb2 = 
		ac.getBean("mb1",MessageBean.class);
	System.out.println(mb1 == mb2);	
	
	}
	
	@Test
	//测试生命周期相关的方法
	public void test2(){
		/*
		 * ApplicationContext接口当中没有
		 * 提供关闭容器的close()方法,需要
		 * 使用其子接口AbstractApplication
		 * Context。 
		 */
		AbstractApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"container/other/applicationContext.xml");
	MessageBean mb2 = 
		ac.getBean("mb2",MessageBean.class);
		System.out.println(mb2);	
	ac.close();
	}
	
	@Test
	//测试延迟加载
	public void test3(){
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"container/other/applicationContext.xml");
	
	}
}
