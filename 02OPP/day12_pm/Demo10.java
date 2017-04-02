package day12;

public class Demo10 {
	public static void main(String[] args) {
		/*
		 * Java中的常量在编译时候被“擦除”，替换为
		 * 常量本身的数值，所以如下代码运行时候
		 * Java不会加载类，不会执行静态代码块
		 */
		System.out.println(Hoo.NUM);//100
	}
}
class Hoo{
	public static final int NUM = 100;
	static{
		System.out.println("加载Hoo"); 
	}
}