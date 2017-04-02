package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ������߶�дЧ�ʣ���Ҫ��߶�д��������������
 * ��д�����ﵽ��
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
			= new RandomAccessFile("1.flv","r");
	
		RandomAccessFile desc
			= new RandomAccessFile("1_copy.flv","rw");
	
		//��¼ÿ��ʵ�ʶ�ȡ�����ֽ���
		int len = -1;
		//һ�ζ�д10K
		byte[] buf = new byte[1024*10];
		
		long start = System.currentTimeMillis();
		while((len = src.read(buf))!= -1){
			desc.write(buf,0,len);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("������ϣ���ʱ:"+(end-start)+"ms");
		src.close();
		desc.close();
		
	}
}




