package day06;

import java.io.File;

/**
 * ɾ��һ���ļ�
 * @author Administrator
 *
 */
public class FileDemo2 {
	public static void main(String[] args) {
		File file = new File("test.txt");
		if(file.exists()){
			file.delete();
			System.out.println("ɾ�����!");
		}
	}
}





