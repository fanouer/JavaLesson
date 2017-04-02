package day06;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RAF�ṩ�˷����д�����������ݵķ���
 * �Լ�����ָ��Ķ�д��ʽ
 * @author Administrator
 *
 */
public class RandomAccessFileDemo5 {
	public static void main(String[] args)throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"demo.dat","rw"	
			);
		/*
		 * long getFilePointer()
		 * ��ȡRandomAccessFile��ǰָ��λ��
		 */
		System.out.println("pos:"+raf.getFilePointer());
		
		//01111111 11111111 11111111 11111111
		int max = Integer.MAX_VALUE;		
		//����д��4���ֽڣ���intֵд��
		raf.writeInt(max);
		
		System.out.println("pos:"+raf.getFilePointer());
		
		double dou = 123.123;
		raf.writeDouble(dou);
		
		System.out.println("pos:"+raf.getFilePointer());
		
		long l = 1234;
		raf.writeLong(l);
		System.out.println("pos:"+raf.getFilePointer());
		
		/*
		 * void seek(long pos)
		 * ��ָ���ƶ���ָ��λ��
		 */
		raf.seek(0);//�ƶ����ļ���һ���ֽڴ�
		System.out.println("pos:"+raf.getFilePointer());
		
		
		//��intֵ������ 
		int i = raf.readInt();
		System.out.println(i);
		
		System.out.println("pos:"+raf.getFilePointer());
		
		double d = raf.readDouble();
		System.out.println(d);
		
		long lon = raf.readLong();
		System.out.println(lon);
		
		//�ٶ�double
		raf.seek(4);
		d = raf.readDouble();
		System.out.println(d);
		raf.close();
		
		
	}
}





