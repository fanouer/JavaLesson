package day01;
/**
 * String substring(int start,int end)
 * 截取当前字符串，从start处开始截取到end为止，
 * 但是不包含end处的字符。
 * 在JAVA API中通常用两个数字表示范围时，都是
 * "含头不含尾"的。
 * 
 * @author Administrator
 *
 */
public class StringDemo5 {
	public static void main(String[] args) {
		//            01234567890123
		String str = "www.oracle.com";
		//截取oracle
		String sub = str.substring(4,10);
		System.out.println(sub);
		
		/*
		 * 还有一个传入一个参数的方法，则是从
		 * 指定位置开始连续截取到字符串末尾
		 */
		sub = str.substring(4);
		System.out.println(sub);
	}
}





