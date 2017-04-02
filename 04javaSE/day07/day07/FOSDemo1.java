package day07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.FileOutputStream
 * 文件字节输出流
 * 是一个低级流，作用是向文件中写出数据。
 * @author Administrator
 *
 */
public class FOSDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 默认创建的文件输出流是覆盖写操作，
		 * 会将该文件原来的内容全部删除。
		 * 
		 * 若传入第二个参数(boolean)且为true
		 * 时，则为追加写模式。那么写入的内容会在
		 * 文件末尾被追加。
		 */
		FileOutputStream fos
			= new FileOutputStream(
				"fos.dat",true	
			);
		String str = "摩擦摩擦,是魔鬼的步伐!";
		byte[] data = str.getBytes("UTF-8");
		fos.write(data);
		System.out.println("写出完毕!");
		fos.close();
	}
}





