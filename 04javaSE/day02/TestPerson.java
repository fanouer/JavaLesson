package day02;

public class TestPerson {
	public static void main(String[] args) {
		Point p = new Point(1,2);
		/*
		 * JAVA API提供的类大部分都重写了toString
		 * 但是当我们需要调用我们自己定义的类的
		 * toString方法时，就应当重写它。
		 * 因为Object本身的该方法返回的字符串是
		 * 对象的地址，没有什么实际意义。
		 */
		String str = p.toString();
		System.out.println(str);
		/*
		 * System.out.println(Object o)
		 * 该方法可以向控制台输出一切对象，输出的
		 * 是给定对象toString()方法返回的字符串
		 */
		System.out.println(p);
		
		
		Point p1 = new Point(1,2);
		
		System.out.println(p==p1);//false
		System.out.println(p.equals(p1));//true
		
		
	}
}





