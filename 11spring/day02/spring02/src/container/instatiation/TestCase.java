package container.instatiation;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ������(ʹ����junit���Կ��)
 */
public class TestCase {
	@Test
	public void test1(){
		//����spring����
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"container/instatiation" +
	"/applicationContext.xml");
		//ͨ��������ö���
		ExampleBean eb1 = 
			ac.getBean("eb1",ExampleBean.class);
		System.out.println(eb1);
	}
	
	@Test
	//���Ծ�̬����������������
	public void test2(){
		//����spring����
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"container/instatiation" +
	"/applicationContext.xml");
		//ͨ��������ö���
		Calendar cal1 = 
			ac.getBean("cal1",Calendar.class);
		System.out.println(cal1);
	}
	
	@Test
	//����ʵ������������������
	public void test3(){
		//����spring����
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
	"container/instatiation" +
	"/applicationContext.xml");
		//ͨ��������ö���
		Calendar cal = 
			ac.getBean("cal2",Calendar.class);
		System.out.println(cal);
		Date date1 = 
			ac.getBean("date1",Date.class);
		System.out.println(date1);
	}
	
	
	
	
	
	
	
}
