package first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ��ʾ�������spring����
 *
 */
public class Test {

	public static void main(String[] args) {
		//ע�������ļ���·�����ļ���Ҫ��ʵ��
		//һ�¡�
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
		"first/applicationContext.xml");
		System.out.println(ac);
	}

}
