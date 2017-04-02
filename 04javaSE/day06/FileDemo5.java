package day06;

import java.io.File;

/**
 * 删除目录
 * @author Administrator
 *
 */
public class FileDemo5 {
	public static void main(String[] args) {
		/*
		 * 若想删除目录，必须保证该目录是一个空目录
		 */
		File dir = new File("demo");
		if(dir.exists()){
			dir.delete();
			System.out.println("删除完毕！");
		}
		
	}
}
