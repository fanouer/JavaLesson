package day06;

import java.io.File;

/**
 * ��ȡһ��Ŀ¼�е���������
 * @author Administrator
 *
 */
public class FileDemo6 {
	public static void main(String[] args) {
		/*
		 * ��ȡ��ǰĿ¼�µ���������
		 */
		File dir = new File(".");
		if(dir.isDirectory()){
			/*
			 * File[] listFiles()
			 * ��ȡ��ǰĿ¼�е���������
			 */
			File[] subs = dir.listFiles();
			for(File sub : subs){
				if(sub.isFile()){
					System.out.print("�ļ�:");
				}else{
					System.out.print("Ŀ¼:");
				}
				System.out.println(sub.getName());
			}
			
		}
	}
}






