package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 写出一组字节
 * @author Administrator
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.txt","rw"
			);
		
		String str = "大家好才是真的好";
		/*
		 * byte[] getBytes()
		 * 字符串的该方法用于将当前字符串按照
		 * 当前系统默认字符集转换为一组字节(字符串编码)
		 * 
		 * 
		 * byte[] getBytes(String charsetName)
		 * 可以按照指定的字符集将字符串转换为字节
		 * 常用字符集:
		 * UTF-8
		 * GBK
		 * ISO8859-1
		 */
		byte[] data = str.getBytes("UTF-8");
		
		/*
		 * void write(byte[] data)
		 * 将给定的字节数组中的所有字节一次性写入到
		 * 文件中
		 * 
		 * void write(byte[] data,int off,int len)
		 * 将给定的字节数组从off处开始的连续len个字节写入到
		 * 文件
		 */
		raf.write(data);
		
		raf.close();
	}
}






