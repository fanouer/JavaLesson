package demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Utils {
	
	/**
	 * 调用某对象的某个方法
	 * @param obj 某个对象
	 * @param method 某方法名
	 * @param paramTypes 参数类型列表
	 * @param params 参数列表
	 * @return 方法结果
	 * 
	 *  Koo koo = new Koo();
	 *  Object val=execute(koo, "sayHello", 
	 *  	new Class[]{String.class, String.class},
	 *  	new Object[]{"Tom", "Jerry"});
	 */
	public static Object execute(
		Object obj, 
		String method, 
		Class[] paramTypes,
		Object[] params)
		throws Exception {
		Class cls = obj.getClass();
		//找到方法信息
		Method m = cls.getDeclaredMethod(
			method, paramTypes);
		//调用方法, 在对象上执行方法，params传递的参数
		// invoke 调用
		Object val = m.invoke(obj, params);
		return val;
	}
	
	
	/**
	 * 返回某对象的某个属性
	 * @param obj 某对象
	 * @param fieldName 某个属性的名
	 * @return 属性的值
	 * 举个栗子：
	 *   Koo koo = new Koo(2,4);
	 *                     a b
	 *   Object val = get(koo, "a");//2
	 *   koo.a;
	 */
	public static Object get(Object obj,
			String fieldName)
		throws Exception{
		//找到Class Object.getClass()
		Class cls = obj.getClass();
		//找到属性信息Field
		Field field = 
			cls.getDeclaredField(fieldName);
		//利用属性信息类Field的get方法获取属性值
		Object val=field.get(obj);//获取对象的属性
		return val;
	}
	
	
	/**
	 * 动态 调用“某个类”的“某个构造器”创建对象
	 * @param className 某个类名
	 * @param paramTypes 某个构造器的参数类型列表
	 * @param params 调用构造器传递的参数列表
	 * @return 一个对象
	 * 例如：
	 * create("java.util.ArrayList",
	 * 	new Class[]{int.class},
	 *  new Object[]{200});
	 *  相当于  new ArrayList(200);
	 */
	public static Object create(
		String className,
		Class[] paramTypes,
		Object[] params)
		throws Exception{
		//动态加载类
		Class cls=Class.forName(className);
		//根据参数类型列表找到构造器信息：
		Constructor constructor =
			cls.getDeclaredConstructor(
			paramTypes);
		//constructor构造器信息，提供执行构造器的方法
		//newInstance，执行这个方法，必须提供
		// 参数列表，其类型与参数类型列表匹配！
		Object obj = 
		  constructor.newInstance(params);
		return obj;
	}
	
	
	/**
	 * 显示一个类的全部构造器信息
	 */
	public static void showInit(
			String className)
		throws Exception {
		//Constructor: 构造器
		Class cls = Class.forName(className);
		Constructor[] constructors=
			cls.getDeclaredConstructors();
		for(Constructor c:constructors){
			System.out.print(c.getName());
			System.out.println(
				Arrays.toString(
				c.getParameterTypes()));
		}
	}
	
	
	/**
	 * 显示一个类的全部方法信息
	 * 参数：是一个动态类名
	 */
	public static void showMethods(
		String className)
		throws Exception {
		Class cls = Class.forName(className);
		/*
		 * 返回cls类信息中全部的方法信息
		 * Declared:声明     Method：方法
		 * Parameter：参数  Type:数据类型
		 */
		Method[] methods =
			cls.getDeclaredMethods();
		for(Method m:methods){
			System.out.print(
				m.getReturnType()+" ");
			System.out.print(m.getName());
			System.out.println(
				Arrays.toString(
				m.getParameterTypes()));
		}
	}
	
	
	
	/**
	 * 显示一个类是全部属性信息
	 * @param className 类名
	 * @throws Exception 类名错误时候抛异常
	 */
	public static void showFileds(
			String className)
		throws Exception {
		//动态加载类(类信息到方法区)
		Class cls = Class.forName(className);
		//动态获取全部属性信息
		Field[] fields = 
			cls.getDeclaredFields();
		//for遍历属性数组，显示全部属性信息
		for(Field f:fields){
			System.out.print(f.getType()+" ");
			System.out.println(f.getName());
		}
	}
	
	
	
}



