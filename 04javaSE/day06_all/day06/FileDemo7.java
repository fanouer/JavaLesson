package day06;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取一个目录中的指定子项
 * @author Administrator
 *
 */
public class FileDemo7 {
	public static void main(String[] args) {
		File dir = new File(".");
		if(dir.isDirectory()){
			MyFilter filter = new MyFilter();
			File[] subs = dir.listFiles(filter);
			for(File sub : subs){
				System.out.println(sub.getName());
			}
		}
	}
}

class MyFilter implements FileFilter{
	/**
	 * 定义过滤条件，当满足条件的File传入时
	 * 应当返回true
	 */
	public boolean accept(File file) {
		System.out.println("正在过滤:"+file.getName());
		//只关注目录
		return file.isDirectory();
	}
	
}





