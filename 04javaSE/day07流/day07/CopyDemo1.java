package day07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ʹ���ļ�������ļ����Ʋ���
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("1.flv");
		
		FileOutputStream fos
			= new FileOutputStream("1_copy2.flv");
		
		int len = -1;
		byte[] data = new byte[1024*10];
		while((len=fis.read(data))!=-1){
			fos.write(data,0,len);
		}
		System.out.println("�������");
		fis.close();
		fos.close();
		
	}
}



