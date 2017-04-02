package day12;

public class Demo07 {
	public static void main(String[] args) {
		/*
		 * final 修饰的局部变量
		 */
		int a = 5;
		final int b;
		b = 6;//可以初始化
		//b = 7;//不能再修改！
		final int c = 6;
		//c = 8;//不能再修改！
		//final 可以避免数据被意外修改
		final int cols = 10;
		
		test(4,5);
		
	}
	
	public static void test(
			final int a, int b){
		//方法的的参数，是在参数传递时候进行初始化
		//a = 5;//编译错误
		b = 6;
		System.out.println(a+","+b);
	}
}










