package homework02;

import java.util.Scanner;

/**
 * 作业3
 * @author Administrator
 *
 */
public class Test3 {
	public static void main(String[] args) {
		System.out.println("请输入一个数字:");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		//整数正则
		String intRegex = "\\d+";
		//小数正则
		String douRegex = "\\d+\\.\\d+";
		
		if(line.matches(intRegex)){
			int i = Integer.parseInt(line);
			System.out.println("这是一个整数:"+i);
		}else if(line.matches(douRegex)){
			double d = Double.parseDouble(line);
			System.out.println("这是一个小数:"+d);		
		}else{
			System.out.println("数字格式不正确!");
		}
		
	}
}







