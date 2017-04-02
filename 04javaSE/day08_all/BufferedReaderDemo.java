package day08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader
 * 缓冲字符输入流
 * 特点:可以一次性读取一行字符串
 * @author Administrator
 *
 */
public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream(
				"src"+File.separator+
				"day08"+File.separator+
				"BufferedReaderDemo.java"
			);
		
		InputStreamReader isr
			= new InputStreamReader(fis);
		
		BufferedReader br
			= new BufferedReader(isr);
		
		/*
		 * String readLine()
		 * BR提供了读取一行字符串的方法，该方法会
		 * 顺序读取若干字符，直到读取换行符为止，
		 * 然后将换行符前的所有字符组成一个字符串
		 * 返回。注意，返回的字符串中不含有换行符!
		 * 若返回值为null，则表示读取到了文件末尾。
		 */
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println(line);
		}
		br.close();
	}
}








