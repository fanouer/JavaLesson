package day08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader
 * �����ַ�������
 * �ص�:����һ���Զ�ȡһ���ַ���
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
		 * BR�ṩ�˶�ȡһ���ַ����ķ������÷�����
		 * ˳���ȡ�����ַ���ֱ����ȡ���з�Ϊֹ��
		 * Ȼ�󽫻��з�ǰ�������ַ����һ���ַ���
		 * ���ء�ע�⣬���ص��ַ����в����л��з�!
		 * ������ֵΪnull�����ʾ��ȡ�����ļ�ĩβ��
		 */
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println(line);
		}
		br.close();
	}
}








