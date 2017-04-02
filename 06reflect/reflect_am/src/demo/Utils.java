package demo;

import java.lang.reflect.Field;

public class Utils {
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



