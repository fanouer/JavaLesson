package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * String->Date
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo2 {
	public static void main(String[] args) throws ParseException {
		String str 
			= "2008��8��8�� 20:08:08";
		
		SimpleDateFormat format
			= new SimpleDateFormat(
			  "yyyy��M��d�� HH:mm:ss"		
			);
		/*
		 * Date parse(String str)
		 * ���������ַ�������SimpleDateFormat
		 * ָ�������ڸ�ʽ����ΪDate		
		 */
		Date date = format.parse(str);	
		
		System.out.println(date);
	}
}








