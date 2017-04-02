package demo;

import org.junit.Test;

/**
 * 测试案例 
 * Test：测试    Case：案例
 */
public class TestCase {
	
	//@Test //Junit 提供的注解
	public void testHelloWorld(){
		System.out.println("Hello World"); 
	}
	
	//@Test
	public void testHelloKitty(){
		System.out.println("Hello Kitty"); 
	}
	
	/**
	 * 测试显示一个类的全部方法
	 */
	//@Test
	public void testShowMethods()
		throws Exception{
		String className="java.lang.String";
		Utils.showMethods(className);
	}
	
	/**
	 * 测试显示一个累的全部构造器
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
		//参数类型列表 (int)
		Class[] types = 
			new Class[]{int.class};
		//参数列表 (200)
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
		//静态访问属性
		koo.a = 2;
		//动态访问属性
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
			new Object[]{"老鼠", "大米！"});
		System.out.println(val);
	} 
}













