package day08;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * java.io.PrintWriter
 * �����Զ���ˢ�µĻ����ַ������
 * �ṩ�˺ܶ๹�췽�������Է���Ĵ�������
 * @author Administrator
 *
 */
public class PrintWriterDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * ����ļ����ٴ���PW
		 * PrintWriter(File file)
		 * PrintWriter(String path)
		 * 
		 * pw.txt�ļ�д����
		 */
		PrintWriter pw 
			= new PrintWriter("pw.txt","UTF-8");
		/*
		 * PrintWriter�ṩ���������ص�
		 * print,println������
		 * �������ֱ��д���������ͣ�
		 * println(int i):��������intֵ���ַ���
		 * ����ʽд����
		 */
		pw.println("����ʦ͵�Ҽ��̣�");
		pw.println("������꣡");
		pw.println("���������ң�");
		pw.println("û�ޣ���Ϊ��������ģ�");
		pw.println("�������������ҵģ����ң�");
		System.out.println("д�����!");
		pw.close();
	}
}







