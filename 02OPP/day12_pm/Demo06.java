package day12;

public class Demo06 {
	public static void main(String[] args) {
		System.out.println("HI"); 
		Koo k = new Koo();
		Koo k2 = new Koo();
	}
}
class Koo{
	static int a = 6;
	/*
	 * 类中可以声明静态代码块
	 *  1） 静态代码块，在类加载期间执行
	 *    类只加载一次，静态代码块只能执行一次
	 *  2) 使用场合：用于初始化静态的一次性资源
	 */
	static{
		for(int i=1; i<5; i++){
			System.out.println(a); 
		}
	}
}


