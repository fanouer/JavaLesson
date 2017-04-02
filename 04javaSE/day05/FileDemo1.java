package day05;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.io.File 
 * �������������ļ�ϵͳ�е�һ���ļ���Ŀ¼
 * ʹ��������:
 * �����ļ���Ŀ¼������(���֣���С��)
 * ����Ŀ¼�е�����
 * �����ļ���Ŀ¼(������ɾ��)
 * ���ǲ���:
 * �����ļ�����
 * @author Administrator
 *
 */
public class FileDemo1 {
	public static void main(String[] args) {
		/*
		 * ʹ�����Ŀ¼:��ǰĿ¼����Ŀ��Ŀ¼
		 */
		File file = new File(
			"."+File.separator+"demo.txt"
		);
		//��ȡ�ļ���
		String name = file.getName();
		System.out.println("�ļ���:"+name);
		
		//�ļ���С(�ֽ�)
		long length = file.length();
		System.out.println("��С:"+length+"�ֽ�");
		
		//�ж��Ƿ�Ϊ�ļ�
		boolean isFile = file.isFile();
		System.out.println("�ļ�:"+isFile);
		
		//�ж��Ƿ�ΪĿ¼(�ļ���)
		boolean isDir = file.isDirectory();
		System.out.println("Ŀ¼:"+isDir);
		//�ɶ�����д��������
		file.canRead();
		file.canWrite();
		file.canExecute();
		
		boolean isHidden = file.isHidden();
		System.out.println("�Ƿ�����:"+isHidden);
		
		//����޸�ʱ��
		long lastModified = file.lastModified();
		Date date = new Date(lastModified);
		SimpleDateFormat format
			= new SimpleDateFormat(
			  "yyyy��M��d�� HH:mm:ss"
			);
		System.out.println("����޸�����:"+format.format(date));
	}
}









