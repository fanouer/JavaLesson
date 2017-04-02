package day08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 获取用户输入的内容并写入文件
 * @author Administrator
 *
 */
public class PrintWriterDemo3 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入文件名:");
		String name = scanner.nextLine();
		/*
		 * 当创建PW时，若第一个参数为流，则可以指定
		 * 第二个参数，该参数是一个boolean值，若
		 * 该值为true，则具有自动行刷新，即:
		 * 每当通过println方法写出内容时，会自动
		 * 指定flush()方法。
		 */
		PrintWriter pw = new PrintWriter(
			new OutputStreamWriter(
				new FileOutputStream(
					name	
				),"UTF-8"	
			),true	
		);
		System.out.println("请输入内容:");
		String line = null;
		while(true){
			line = scanner.nextLine();
			if("exit".equals(line)){
				System.out.println("再见!");
				break;
			}
			pw.println(line);
		}
		pw.close();
	}
}





