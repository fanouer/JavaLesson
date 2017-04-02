package day08;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * java.io.PrintWriter
 * 具有自动行刷新的缓冲字符输出流
 * 提供了很多构造方法，可以方便的创建该流
 * @author Administrator
 *
 */
public class PrintWriterDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 针对文件快速创建PW
		 * PrintWriter(File file)
		 * PrintWriter(String path)
		 * 
		 * pw.txt文件写操作
		 */
		PrintWriter pw 
			= new PrintWriter("pw.txt","UTF-8");
		/*
		 * PrintWriter提供了若干重载的
		 * print,println方法。
		 * 例如可以直接写出基本类型：
		 * println(int i):将给定的int值以字符串
		 * 的形式写出。
		 */
		pw.println("苍老师偷我键盘！");
		pw.println("拿我鼠标！");
		pw.println("还不告诉我！");
		pw.println("没辙，因为这个是他的！");
		pw.println("但是里面电池是我的！还我！");
		System.out.println("写出完毕!");
		pw.close();
	}
}







