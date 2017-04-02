package day08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 使用PrintWriter处理其他流
 * PrintWriter提供的构造方法允许我们直接处理
 * 字节流，也可以处理字符流。
 * 注意:只有处理其他流的形式创建PrintWriter才会
 *     具有自动行刷新功能。
 * @author Administrator
 *
 */
public class PrintWriterDemo2 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream("pw1.txt");
		
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"UTF-8");
		
		PrintWriter pw
			= new PrintWriter(osw);
		
		pw.println("锄禾日当午");
		pw.println("清明上河图");
		
		System.out.println("写出完毕!");
		pw.close();
	}
}










