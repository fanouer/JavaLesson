package day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * ʹ���ַ��������ı��ļ�
 * �ڸ��ƵĹ����п��Խ���ת���ַ���������
 * ����������ǽ�һ��GBK������ļ�ת��ΪUTF-8����
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
		
		System.out.println("�������!");
		isr.close();
		osw.close();
	}
}



