package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * ������д�ļ����ݵ��ࡣ
 * �����ǻ���ָ����еĶ�д��������:
 * RAF���Ƕ�д��ǰָ��ָ��λ���ϵ����ݣ�Ȼ��ָ���
 * �Զ�����ƶ���
 * ����RAF������ģʽ:ֻ������д��
 * @author Administrator
 *
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.dat","rw"
			);		
		/*
		 * void write(int d)
		 * ���ļ���д��һ���ֽڣ�д������
		 * ������intֵ����ʾ��2���Ƶ�"�Ͱ�λ"
		 *                            vvvvvvvv
		 * 00000000 00000000 00000001 00000001
		 */
		raf.write(1);
		
		raf.close();
		
	}
}








