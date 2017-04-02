package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取字节
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.dat","r"	
			);
		/*
		 * int read()
		 * 读取一个字节，并以int形式返回。
		 * 只有低八位有效。
		 * 若返回的int值为-1,则表示读取到文件末尾。
		 * 
		 * 00000000 00000000 00000000 11111111
		 */
		int i = raf.read();
		System.out.println(i);
		
		raf.close();
	}
}








