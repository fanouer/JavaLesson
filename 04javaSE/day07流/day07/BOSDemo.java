package day07;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���������д���ֽ�
 * @author Administrator
 *
 */
public class BOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream("bos.txt");
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);		
		String str = "���!";
		byte[] data = str.getBytes();
		bos.write(data);
		System.out.println("д�����!");
		/*
		 * ���������е���������һ����д����
		 */
		bos.flush();		
		bos.close();
		
		
	}
}








