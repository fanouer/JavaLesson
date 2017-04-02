package day06;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RAF提供了方便读写基本类型数据的方法
 * 以及基于指针的读写方式
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
		 * 获取RandomAccessFile当前指针位置
		 */
		System.out.println("pos:"+raf.getFilePointer());
		
		//01111111 11111111 11111111 11111111
		int max = Integer.MAX_VALUE;		
		//连续写出4个字节，将int值写出
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
		 * 将指针移动到指定位置
		 */
		raf.seek(0);//移动到文件第一个字节处
		System.out.println("pos:"+raf.getFilePointer());
		
		
		//将int值读回来 
		int i = raf.readInt();
		System.out.println(i);
		
		System.out.println("pos:"+raf.getFilePointer());
		
		double d = raf.readDouble();
		System.out.println(d);
		
		long lon = raf.readLong();
		System.out.println(lon);
		
		//再读double
		raf.seek(4);
		d = raf.readDouble();
		System.out.println(d);
		raf.close();
		
		
	}
}





