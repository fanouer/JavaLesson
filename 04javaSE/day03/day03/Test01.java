package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * ��ϰ:
 * Ҫ���û������Լ�������:
 * ��ʽΪ:yyyy-MM-dd
 * Ȼ�󾭹�������㣬���Ϊ:������Ϊֹһ�����˶�����?
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) throws ParseException {
		System.out.println("��������������:");
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
			"��ϲ���Ѿ�����:"+time+"��!���������!");
		
	}
}






