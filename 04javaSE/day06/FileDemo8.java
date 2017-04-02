package day06;

import java.io.File;

/**
 * 编写一个程序，要求完成1+2+3+4...+100
 * 每加1次输出一次结果。
 * 代码不能超过20行
 * 代码中不得出现for while关键字。
 * 
 * 
 * 删除给定的文件或目录
 * @author Administrator
 *
 */
public class FileDemo8 {
	public static void main(String[] args) {
		File dir = new File("a");
		delete(dir);
	}
	/**
	 * 将给定的File所表示的文件或目录删除
	 * 递归
	 * @param file
	 */
	public static void delete(File file){
		if(file.isDirectory()){
			//先将所有子项删除
			File[] subs = file.listFiles();
			for(File sub : subs){
				delete(sub);
			}
		}
		file.delete();
	}
}





