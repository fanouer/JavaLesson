package day06;

import java.io.File;

/**
 * ����һ��Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo3 {
	public static void main(String[] args) {
		/*
		 * ��ǰĿ¼�´���Ŀ¼demo
		 */
		File dir = new File("demo");
		if(!dir.exists()){
			dir.mkdir();
			System.out.println("������ϣ�");
		}
	}
}





