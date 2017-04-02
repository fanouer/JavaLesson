package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * 用来读写文件数据的类。
 * 该类是基于指针进行的读写操作，即:
 * RAF总是读写当前指针指向位置上的数据，然后指针会
 * 自动向后移动。
 * 创建RAF有两种模式:只读，读写。
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
		 * 向文件中写出一个字节，写出的是
		 * 给定的int值所表示的2进制的"低八位"
		 *                            vvvvvvvv
		 * 00000000 00000000 00000001 00000001
		 */
		raf.write(1);
		
		raf.close();
		
	}
}








