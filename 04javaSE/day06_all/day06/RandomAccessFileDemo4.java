package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��ȡһ���ֽ�
 * @author Administrator
 *
 */
public class RandomAccessFileDemo4 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.txt","r"	
			);
		
		byte[] data = new byte[50];
		/*
		 * int read(byte[] data)
		 * ��ͼһ���Զ�ȡ�����ֽ������ܳ��ȵ��ֽ���
		 * �����뵽�������ֽ������У�����ֵΪʵ��
		 * ��ȡ�����ֽ���.������ֵΪ-1����ʾ��ȡ����
		 * �ļ�ĩβ��
		 */
		int len = raf.read(data);
		System.out.println("������:"+len+"���ֽ�");
		
		String str = new String(
			data,0,len,"UTF-8"
		);
		
		System.out.println(str);
		
		raf.close();
	}
}






