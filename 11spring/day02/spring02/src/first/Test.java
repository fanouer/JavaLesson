package first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示如何启动spring容器
 *
 */
public class Test {

	public static void main(String[] args) {
		//注意配置文件的路径与文件名要与实际
		//一致。
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
		"first/applicationContext.xml");
		System.out.println(ac);
	}

}
