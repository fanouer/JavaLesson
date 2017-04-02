package day02;
/**
 * JDK1.5之后推出的一个新的特性:自动拆装箱
 * 该特性不是JVM认可的，而是编译器认可。
 * @author Administrator
 *
 */
public class IntegerDemo3 {
	public static void main(String[] args) {
		int i = 1;
		/*
		 * 编译器在编译下面内容是，补充了代码：
		 * Integer in = Integer.valueOf(1);
		 * 自动装箱
		 */
		Integer in = 1;
		
		/*
		 * 编译器在编译下面内容是，补充了代码：
		 * int a = in.intValue()
		 * 自动拆箱
		 */
		int a = in;
		
	}
}




