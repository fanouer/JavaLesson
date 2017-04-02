package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 若想提高读写效率，需要提高读写的数据量来减少
 * 读写次数达到。
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
			= new RandomAccessFile("1.flv","r");
	
		RandomAccessFile desc
			= new RandomAccessFile("1_copy.flv","rw");
	
		//记录每次实际读取到得字节量
		int len = -1;
		//一次读写10K
		byte[] buf = new byte[1024*10];
		
		long start = System.currentTimeMillis();
		while((len = src.read(buf))!= -1){
			desc.write(buf,0,len);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("复制完毕！耗时:"+(end-start)+"ms");
		src.close();
		desc.close();
		
	}
}




