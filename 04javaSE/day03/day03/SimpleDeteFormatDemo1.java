package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * 该类的作用是可以按照指定的日期格式在:
 * Date与String之间相互转换
 * @author Administrator
 *
 */
public class SimpleDeteFormatDemo1 {
	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.println(now);
		
		/*
		 * 2016-02-29 10:37:55
		 * yyyy-MM-dd HH:mm:ss
		 */
		SimpleDateFormat format
			= new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss E a"	
			);
		/*
		 * String format(Date date)
		 * 根据当前SimpleDateFormat指定的日期
		 * 格式将给定的Date转换为字符串
		 * Date->String
		 */
		String str = format.format(now);
		System.out.println(str);
	}
}






