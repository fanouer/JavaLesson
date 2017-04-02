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
			= "2008年8月8日 20:08:08";
		
		SimpleDateFormat format
			= new SimpleDateFormat(
			  "yyyy年M月d日 HH:mm:ss"		
			);
		/*
		 * Date parse(String str)
		 * 将给定的字符串按照SimpleDateFormat
		 * 指定的日期格式解析为Date		
		 */
		Date date = format.parse(str);	
		
		System.out.println(date);
	}
}








