package demo;

import org.junit.Test;

/**
 * ���԰��� 
 * Test������    Case������
 */
public class TestCase {
	
	//@Test //Junit �ṩ��ע��
	public void testHelloWorld(){
		System.out.println("Hello World"); 
	}
	
	//@Test
	public void testHelloKitty(){
		System.out.println("Hello Kitty"); 
	}
	
	/**
	 * ������ʾһ�����ȫ������
	 */
	//@Test
	public void testShowMethods()
		throws Exception{
		String className="java.lang.String";
		Utils.showMethods(className);
	}
	
	/**
	 * ������ʾһ���۵�ȫ��������
	 */
	//@Test
	public void testShowInit()
		throws Exception{
		String className =
				"java.io.PrintWriter";
		Utils.showInit(className); 
	}
	
	//@Test
	public void testCreate()
		throws Exception {
		String className=
			"java.util.ArrayList";
		//���������б� (int)
		Class[] types = 
			new Class[]{int.class};
		//�����б� (200)
		Object[] params = 
			new Object[]{200};
		Object obj = Utils.create(
				className, types, params);
		System.out.println(obj); 
	}
	
	//@Test
	public void testGet()
		throws Exception {
		Koo koo = new Koo();
		//��̬��������
		koo.a = 2;
		//��̬��������
		Object val = Utils.get(koo,"a");
		System.out.println(val);//2
	}
	
	@Test
	public void testExecute()
		throws Exception{
		Koo koo = new Koo();
		Object val = Utils.execute(koo,
			"sayHello",
			new Class[]{String.class, String.class},
			new Object[]{"����", "���ף�"});
		System.out.println(val);
	} 
}













