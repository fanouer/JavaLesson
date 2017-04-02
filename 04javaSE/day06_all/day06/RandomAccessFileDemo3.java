package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * д��һ���ֽ�
 * @author Administrator
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.txt","rw"
			);
		
		String str = "��Һò�����ĺ�";
		/*
		 * byte[] getBytes()
		 * �ַ����ĸ÷������ڽ���ǰ�ַ�������
		 * ��ǰϵͳĬ���ַ���ת��Ϊһ���ֽ�(�ַ�������)
		 * 
		 * 
		 * byte[] getBytes(String charsetName)
		 * ���԰���ָ�����ַ������ַ���ת��Ϊ�ֽ�
		 * �����ַ���:
		 * UTF-8
		 * GBK
		 * ISO8859-1
		 */
		byte[] data = str.getBytes("UTF-8");
		
		/*
		 * void write(byte[] data)
		 * ���������ֽ������е������ֽ�һ����д�뵽
		 * �ļ���
		 * 
		 * void write(byte[] data,int off,int len)
		 * ���������ֽ������off����ʼ������len���ֽ�д�뵽
		 * �ļ�
		 */
		raf.write(data);
		
		raf.close();
	}
}






