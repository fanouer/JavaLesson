package day02;
/**
 * 基本类型参与面向对象开发
 * @author Administrator
 *
 */
public class IntegerDemo {
	public static void main(String[] args) {
		int a = 1;
		//将基本类型转换为包装类
		Integer i1 = new Integer(a);
		//推荐使用valueOf方法转换为包装类
		Integer i2 = Integer.valueOf(a);
		
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
		
		
		/*
		 * 由于数字类型包装类都继承子Number
		 * 而该类定义了可以在几种数字类型间转换
		 * 的方法。
		 */
		Double d = Double.valueOf(128.123);
		double dou = d.doubleValue();
		System.out.println("d:"+dou);
		
		int in = d.intValue();
		System.out.println("i:"+in);
		
		byte b = d.byteValue();
		System.out.println("b:"+b);
		
		/*
		 * 数字类型包装类有两个常量:
		 * MAX_VALUE:对应基本类型最大值
		 * MIN_VALUE:对应基本类型最小值
		 */
		//int最大值?
		int max = Integer.MAX_VALUE;
		System.out.println("imax:"+max);
		int min = Integer.MIN_VALUE;
		System.out.println("imin:"+min);
		
		long lmax = Long.MAX_VALUE;
		
	}
	
}











