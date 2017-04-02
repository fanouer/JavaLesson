package demo;

import java.lang.reflect.Field;

public class Demo02 {

	public static void main(String[] args)
		throws Exception{
		//Koo k = new Koo();
		//k.
		
		String className = "demo.Koo";
		//动态加载类
		Class cls = Class.forName(className);
		//动态获取属性信息
		Field[] fields = 
				cls.getDeclaredFields(); 
		//Field 封装了一个属性相关的信息
		System.out.println(fields.length);
		//getName() 获取属性的名
		System.out.println(
				fields[0].getName());
		System.out.println(
				fields[1].getName());
	}

}
