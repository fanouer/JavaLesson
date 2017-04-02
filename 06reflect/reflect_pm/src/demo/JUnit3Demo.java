package demo;

import java.lang.reflect.Method;

public class JUnit3Demo {

	public static void main(String[] args) 
		throws Exception {
		String className = "demo.TestCase";
		
		Class cls = Class.forName(className);
		
		Object obj = cls.newInstance();
		
		Method[] methods = 
			cls.getDeclaredMethods();
		
		for (Method method : methods) {
			if(method.getName().startsWith("test")
			&& method.getParameterTypes().length==0){
				method.invoke(obj, null);
			}
		}
	}
	
}






