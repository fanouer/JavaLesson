package day06;

import java.io.File;
import java.io.IOException;

/**
 * ʹ��File����һ�����ļ�
 * @author Administrator
 *
 */
public class FileDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * ��ǰĿ¼�´���һ���ļ�test.txt
		 */
		File file = new File("test.txt");
		/*
		 * boolean exists()
		 * �жϵ�ǰFile��ʾ���ļ���Ŀ¼�Ƿ���ʵ����
		 */
		if(!file.exists()){
			file.createNewFile();
			System.out.println("�������!");
		}
		
	}
}





