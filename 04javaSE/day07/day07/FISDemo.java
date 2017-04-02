package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * java.io.FileInputStream
 * 低级流，用于来读取文件数据的流
 * @author Administrator
 *
 */
public class FISDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("fos.dat");
		
		byte[] data = new byte[100];
		
		int len = fis.read(data);
		
		String str = new String(data,0,len,"UTF-8");
		
		System.out.println(str);
		
		fis.close();
		
	}
}





