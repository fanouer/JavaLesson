package day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ������
 * �߼���:���ܶ�������(û������)��Ҫ������һ��������
 *       ��������е����ݣ������ǵĶ�д������
 * ʹ�û������������߶�дЧ�ʡ�      
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("1.flv");
		FileOutputStream fos
			= new FileOutputStream("1_copy3.flv");
		
		BufferedInputStream bis
			= new BufferedInputStream(fis);
		
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);
		
		long start = System.currentTimeMillis();
		int d = -1;
		while((d=bis.read())!=-1){
			bos.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("�������,��ʱ:"+(end-start)+"ms");
		/*
		 * ֻ��Ҫ�ر������ĸ߼�������
		 */
		bis.close();
		bos.close();
	}
}






