package day06;

import java.io.File;

/**
 * ɾ��Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo5 {
	public static void main(String[] args) {
		/*
		 * ����ɾ��Ŀ¼�����뱣֤��Ŀ¼��һ����Ŀ¼
		 */
		File dir = new File("demo");
		if(dir.exists()){
			dir.delete();
			System.out.println("ɾ����ϣ�");
		}
		
	}
}
