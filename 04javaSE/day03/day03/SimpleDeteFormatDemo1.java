package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * ����������ǿ��԰���ָ�������ڸ�ʽ��:
 * Date��String֮���໥ת��
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
		 * ���ݵ�ǰSimpleDateFormatָ��������
		 * ��ʽ��������Dateת��Ϊ�ַ���
		 * Date->String
		 */
		String str = format.format(now);
		System.out.println(str);
	}
}






