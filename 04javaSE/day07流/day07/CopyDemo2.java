package day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流
 * 高级流:不能独立存在(没有意义)，要基于另一个流工作
 *       处理该流中的数据，简化我们的读写操作。
 * 使用缓冲流后可以提高读写效率。      
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("1.flv");
		FileOutputStream fos
			= new FileOutputStream("1_copy3.flv");
		
		BufferedInputStream bis
			= new BufferedInputStream(fis);
		
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);
		
		long start = System.currentTimeMillis();
		int d = -1;
		while((d=bis.read())!=-1){
			bos.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕,耗时:"+(end-start)+"ms");
		/*
		 * 只需要关闭最外层的高级流即可
		 */
		bis.close();
		bos.close();
	}
}






