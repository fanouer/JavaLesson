package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��ȡ�ֽ�
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.dat","r"	
			);
		/*
		 * int read()
		 * ��ȡһ���ֽڣ�����int��ʽ���ء�
		 * ֻ�еͰ�λ��Ч��
		 * �����ص�intֵΪ-1,���ʾ��ȡ���ļ�ĩβ��
		 * 
		 * 00000000 00000000 00000000 11111111
		 */
		int i = raf.read();
		System.out.println(i);
		
		raf.close();
	}
}








