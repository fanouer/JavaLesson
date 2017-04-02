package day08;
/**
 * 测试方法中异常的抛出
 * @author Administrator
 *
 */
public class ExceptionDemo3 {
	public static void main(String[] args){
		Person p = new Person();
		/*
		 * 当一个方法上使用throws声明了某个异常
		 * 的抛出时，调用该方法就必须处理该异常，
		 * 处理有两种方式:
		 * 1:使用try-catch捕获并处理该异常
		 * 2:在当前方法上继续使用throws将该异常抛出
		 */
		try {
			p.setAge(1000);
		} catch (IllegalAgeException e) {
			e.printStackTrace();
		}
	
		System.out.println("年龄是:"+p.getAge());
	}
}


