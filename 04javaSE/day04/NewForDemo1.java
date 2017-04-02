package day04;
/**
 * JDK 5.0之后推出了另一个特性:
 * 增强循环，也叫做：新循环，增强for循环，for each
 * 
 * 新循环的作用:
 * 遍历集合或数组使用
 * @author Administrator
 *
 */
public class NewForDemo1 {
	public static void main(String[] args) {
		String[] array 
			= {"one","two","three","four"};
		
		for(int i=0;i<array.length;i++){
			String str = array[i];
			System.out.println(str);
		}

		for(String str:array){
			System.out.println(str);
		}
	}
}







