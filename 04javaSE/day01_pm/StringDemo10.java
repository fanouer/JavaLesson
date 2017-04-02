package day01;
/**
 * String提供了若干静态方法
 * valueOf()
 * 将其他java类型转换为字符串
 * 常用的是将基本类型转换为字符串
 * @author Administrator
 *
 */
public class StringDemo10 {
	public static void main(String[] args) {
		int i = 1;
		//"1"
		String s1 = String.valueOf(i);
		
		String s2 = String.valueOf(123.123);
		
		String s3 = i+"";
	}
}






