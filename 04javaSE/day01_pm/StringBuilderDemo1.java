package day01;
/**
 * java.lang.StringBuilder
 * 由于频繁修改字符串内容对系统内存占用会严重影响
 * 系统安全，所以String不适合频繁修改。
 * StringBuilder就是为了解决这个问题出现的类。
 * 其提供了修改字符串的相关方法:
 * 增，删，改，插
 * @author Administrator
 *
 */
public class StringBuilderDemo1 {
	public static void main(String[] args) {
		String str = "好好学习java";
		/*
		 * 将String转换为StringBuilder
		 */
		StringBuffer builder
			= new StringBuffer(str);
				
		/*
		 * StringBuilder转换为String
		 */
		str = builder.toString();
		
		/*
		 * 好好学习java,为了找个好工作!
		 * StringBuilder append(String str)
		 * 在当前字符串末尾追加指定内容
		 */
		builder.append(",为了找个好工作!");
		System.out.println(builder.toString());
		
		/*
		 * 好好学习java,就是为了改变世界!
		 * StringBuilder replace(
		 *  int start,int end,String str
		 * )
		 * 将当前字符串中指定范围内的字符串替换为
		 * 给定内容。
		 */
		builder.replace(9, 17, "就是为了改变世界!");
		System.out.println(builder.toString());
		
		/*
		 * ,就是为了改变世界!
		 * StringBuilder delete(
		 * 	int start,int end
		 * )
		 * 删除指定范围内的字符串
		 * 
		 */
		builder.delete(0, 8);
		System.out.println(builder.toString());
		
		/*
		 * 活着,就是为了改变世界!
		 * StringBuilder insert(
		 * 	int index,String str
		 * )
		 * 在当前字符串的指定位置处插入给定字符串，
		 * 原位置及后续内容顺序向后移动
		 */
		builder.insert(0,"活着");
		System.out.println(builder.toString());
		/*
		 * 翻转字符串
		 */
		builder.reverse();
		System.out.println(builder.toString());
		
	}
}









