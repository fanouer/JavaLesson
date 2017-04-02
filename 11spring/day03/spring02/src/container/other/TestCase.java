package container.other;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ������
 *
 */
public class TestCase {
	@Test
	//����������
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
	//��������������صķ���
	public void test2(){
		/*
		 * ApplicationContext�ӿڵ���û��
		 * �ṩ�ر�������close()����,��Ҫ
		 * ʹ�����ӽӿ�AbstractApplication
		 * Context�� 
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
	//�����ӳټ���
	public void test3(){
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"container/other/applicationContext.xml");
	
	}
}
