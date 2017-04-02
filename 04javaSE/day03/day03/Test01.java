package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 练习:
 * 要求用户输入自己的生日:
 * 格式为:yyyy-MM-dd
 * 然后经过程序计算，输出为:到今天为止一共活了多少天?
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) throws ParseException {
		System.out.println("请输入您的生日:");
		Scanner scanner = new Scanner(System.in);
		String birStr = scanner.nextLine();	
		SimpleDateFormat format
			= new SimpleDateFormat(
				"yyyy-MM-dd"	
			);		
		Date birthday = format.parse(birStr);
		Date now = new Date();	
		long time = now.getTime()-birthday.getTime();
		time = time / 1000 / 60 / 60 / 24;
		System.out.println(
			"恭喜您已经活了:"+time+"天!请继续保持!");
		
	}
}






