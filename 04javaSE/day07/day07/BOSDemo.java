package day07;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲输出流写出字节
 * @author Administrator
 *
 */
public class BOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream("bos.txt");
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);		
		String str = "你好!";
		byte[] data = str.getBytes();
		bos.write(data);
		System.out.println("写出完毕!");
		/*
		 * 将缓冲区中的所有内容一次性写出。
		 */
		bos.flush();		
		bos.close();
		
		
	}
}








