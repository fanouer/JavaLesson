package day07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.InputStreamReader
 * 字符输入流
 * 可以根据指定的字符集将字节转换并读取出来
 * @author Administrator
 *
 */
public class ISRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("osw.txt");
		
		InputStreamReader isr
			= new InputStreamReader(fis,"UTF-8");
//		
//		char[] data = new char[100];
//		int len = isr.read(data);
//		System.out.println("读到了字符:"+len);
//		
//		String str = new String(data,0,len);
//		System.out.println(str);
		
		int d = -1;
		while((d = isr.read())!=-1){
			char c = (char)d;
			System.out.print(c);
		}
		
		isr.close();
		
		
	}
}






