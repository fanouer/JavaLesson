package day06;

import java.io.File;

/**
 * 删除一个文件
 * @author Administrator
 *
 */
public class FileDemo2 {
	public static void main(String[] args) {
		File file = new File("test.txt");
		if(file.exists()){
			file.delete();
			System.out.println("删除完毕!");
		}
	}
}





