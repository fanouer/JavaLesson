package day07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.InputStreamReader
 * �ַ�������
 * ���Ը���ָ�����ַ������ֽ�ת������ȡ����
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
//		System.out.println("�������ַ�:"+len);
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






