package day06;

import java.io.File;
import java.io.FileFilter;

/**
 * ��ȡһ��Ŀ¼�е�ָ������
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
	 * �������������������������File����ʱ
	 * Ӧ������true
	 */
	public boolean accept(File file) {
		System.out.println("���ڹ���:"+file.getName());
		//ֻ��עĿ¼
		return file.isDirectory();
	}
	
}





