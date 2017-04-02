package day02;
/**
 * 包装类提供了一个常用的静态方法
 * 可以将字符串解析为基本类型。
 * 前提是:
 * 该字符串的内容必须正确描述基本类型的值
 * @author Administrator
 *
 */
public class IntegerDemo2 {
	public static void main(String[] args) {
		String str = "123";
		double d = Double.parseDouble(str);
		System.out.println(d+1);
		int i = Integer.parseInt(str);
		System.out.println(i+1);
		
		
	}
}








