package day01;

public class StringDemo2 {
	public static void main(String[] args) {
		String s1 = "123abc";
		String s2 = "123abc";
		/*
		 * java先编译后运行
		 * 当编译期间，编译器发现一个运算表达式所有
		 * 参与的内容都是字面量，则直接运算，将结果
		 * 编译到class文件中
		 * String s3 = "123abc";
		 */
		String s3 = "123"+"abc";
		
		String s = "123";
		String s4 = s + "abc";
		//字符与数字连接还是数字
		String s5 = '1'+23+"abc";
		
		String s6 = "1"+23+"abc";
		
		System.out.println("s1==s2:"+(s1==s2));
		System.out.println("s1==s3:"+(s1==s3));
		System.out.println("s1==s4:"+(s1==s4));
		System.out.println("s1==s5:"+(s1==s5));
		System.out.println("s1==s6:"+(s1==s6));
	}
}
