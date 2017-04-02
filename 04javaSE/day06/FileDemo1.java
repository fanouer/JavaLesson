package day06;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个空文件
 * @author Administrator
 *
 */
public class FileDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 当前目录下创建一个文件test.txt
		 */
		File file = new File("test.txt");
		/*
		 * boolean exists()
		 * 判断当前File表示的文件或目录是否真实存在
		 */
		if(!file.exists()){
			file.createNewFile();
			System.out.println("创建完毕!");
		}
		
	}
}





