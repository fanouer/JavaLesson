package day07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.FileOutputStream
 * �ļ��ֽ������
 * ��һ���ͼ��������������ļ���д�����ݡ�
 * @author Administrator
 *
 */
public class FOSDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * Ĭ�ϴ������ļ�������Ǹ���д������
		 * �Ὣ���ļ�ԭ��������ȫ��ɾ����
		 * 
		 * ������ڶ�������(boolean)��Ϊtrue
		 * ʱ����Ϊ׷��дģʽ����ôд������ݻ���
		 * �ļ�ĩβ��׷�ӡ�
		 */
		FileOutputStream fos
			= new FileOutputStream(
				"fos.dat",true	
			);
		String str = "Ħ��Ħ��,��ħ��Ĳ���!";
		byte[] data = str.getBytes("UTF-8");
		fos.write(data);
		System.out.println("д�����!");
		fos.close();
	}
}





