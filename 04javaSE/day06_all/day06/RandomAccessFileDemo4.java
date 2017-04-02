package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取一组字节
 * @author Administrator
 *
 */
public class RandomAccessFileDemo4 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.txt","r"	
			);
		
		byte[] data = new byte[50];
		/*
		 * int read(byte[] data)
		 * 试图一次性读取给定字节数组总长度的字节量
		 * 并存入到给定的字节数组中，返回值为实际
		 * 读取到得字节量.若返回值为-1，表示读取到了
		 * 文件末尾。
		 */
		int len = raf.read(data);
		System.out.println("读到了:"+len+"个字节");
		
		String str = new String(
			data,0,len,"UTF-8"
		);
		
		System.out.println(str);
		
		raf.close();
	}
}






