package day08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ��ȡ�û���������ݲ�д���ļ�
 * @author Administrator
 *
 */
public class PrintWriterDemo3 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������ļ���:");
		String name = scanner.nextLine();
		/*
		 * ������PWʱ������һ������Ϊ���������ָ��
		 * �ڶ����������ò�����һ��booleanֵ����
		 * ��ֵΪtrue��������Զ���ˢ�£���:
		 * ÿ��ͨ��println����д������ʱ�����Զ�
		 * ָ��flush()������
		 */
		PrintWriter pw = new PrintWriter(
			new OutputStreamWriter(
				new FileOutputStream(
					name	
				),"UTF-8"	
			),true	
		);
		System.out.println("����������:");
		String line = null;
		while(true){
			line = scanner.nextLine();
			if("exit".equals(line)){
				System.out.println("�ټ�!");
				break;
			}
			pw.println(line);
		}
		pw.close();
	}
}





