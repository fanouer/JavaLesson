package day11;

public class Demo02 {

	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		//在栈中大量分配局部变量会照成栈的溢出！
		int a = 5;
		int b = 6;
		int c = 6;
		test();
	}
}





