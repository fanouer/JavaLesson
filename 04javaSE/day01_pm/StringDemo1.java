package day01;

public class StringDemo1 {
	public static void main(String[] args) {
		/*
		 * 字符串的创建应当尽量使用字面量形式创建。
		 * 因为这样做可以重用对象，减少内存开销。
		 */
		String str1 = "helloworld";
		String str2 = "helloworld";
		String str3 = "helloworld";
		//new不会重用字符串对象
		String str4 = new String("helloworld");
		System.out.println(str1);
		System.out.println(str4);
		System.out.println(str1==str3);
		System.out.println(str1==str4);
		
		/*
		 * 修改str1的字符串内容。
		 * 字符串是不变对象，若想改变内容，
		 * 一定会创建新对象。
		 */
		str1 = str1+"!";
		System.out.println("str1:"+str1);
		System.out.println("str3:"+str3);
		System.out.println(str1==str3);
	}
}





