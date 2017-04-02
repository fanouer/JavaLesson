package day01;
/**
 * 频繁修改字符串带来的性能问题
 * @author Administrator
 *
 */
public class StringDemo11 {
	public static void main(String[] args) {
		String str = "a";
		for(int i=0;i<10000000;i++){
			str += str;
		}
		System.out.println("程序运行完毕");
	}
}




