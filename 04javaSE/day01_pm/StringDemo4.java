package day01;
/**
 * int indexOf(String str)
 * 查找给定字符串在当前字符串中的位置。
 * 若当前字符串中不含有给定字符串则返回值为-1，
 * 否则返回的位置为给定字符串第一个字符在当前
 * 字符串中的位置。
 * @author Administrator
 *
 */
public class StringDemo4 {
	public static void main(String[] args) {
		//java编程思想
		//            0123456789012345
		String str = "thinking in java";
		
		int index = str.indexOf("in");
		System.out.println("index:"+index);
		
		/*
		 * 重载方法允许从指定位置处开始查找
		 */
		index = str.indexOf("in",3);
		System.out.println("index:"+index);
		
		/*
		 * int lastIndexOf(String str)
		 * 查找最后一次出现的位置
		 */
		int last = str.lastIndexOf("in");
		System.out.println("last:"+last);
	}
}





