package day08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * ʹ��PrintWriter����������
 * PrintWriter�ṩ�Ĺ��췽����������ֱ�Ӵ���
 * �ֽ�����Ҳ���Դ����ַ�����
 * ע��:ֻ�д�������������ʽ����PrintWriter�Ż�
 *     �����Զ���ˢ�¹��ܡ�
 * @author Administrator
 *
 */
public class PrintWriterDemo2 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream("pw1.txt");
		
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"UTF-8");
		
		PrintWriter pw
			= new PrintWriter(osw);
		
		pw.println("�����յ���");
		pw.println("�����Ϻ�ͼ");
		
		System.out.println("д�����!");
		pw.close();
	}
}










