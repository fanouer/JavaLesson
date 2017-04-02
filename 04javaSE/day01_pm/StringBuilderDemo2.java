package day01;
/**
 * StringBuilder修改字符串内容的效率问题
 * @author Administrator
 *
 */
public class StringBuilderDemo2 {
	public static void main(String[] args) {
		String str = "a";
		StringBuilder builder
			= new StringBuilder(str);
		for(int i=0;i<10000000;i++){
			builder.append("a");
		}
		System.out.println("执行完毕!");
	}
}






