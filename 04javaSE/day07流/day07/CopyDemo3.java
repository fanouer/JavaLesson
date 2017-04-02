package day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 使用字符流复制文本文件
 * 在复制的过程中可以进行转换字符集操作。
 * 下面的例子是将一个GBK编码的文件转换为UTF-8编码
 * @author Administrator
 *
 */
public class CopyDemo3 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream(
				"src"+File.separator+
				"day07"+File.separator+
				"CopyDemo3.java"
			);
		
		FileOutputStream fos
			= new FileOutputStream(
				"CopyDemo3.java"	
			);
		
		InputStreamReader isr
			= new InputStreamReader(fis,"GBK");
		
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"UTF-8");
		
		char[] data = new char[5120];
		int len = -1;
		
		while((len = isr.read(data))!=-1){
			osw.write(data,0,len);
		}
		
		System.out.println("复制完毕!");
		isr.close();
		osw.close();
	}
}



