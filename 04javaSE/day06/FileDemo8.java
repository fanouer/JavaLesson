package day06;

import java.io.File;

/**
 * ��дһ������Ҫ�����1+2+3+4...+100
 * ÿ��1�����һ�ν����
 * ���벻�ܳ���20��
 * �����в��ó���for while�ؼ��֡�
 * 
 * 
 * ɾ���������ļ���Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo8 {
	public static void main(String[] args) {
		File dir = new File("a");
		delete(dir);
	}
	/**
	 * ��������File����ʾ���ļ���Ŀ¼ɾ��
	 * �ݹ�
	 * @param file
	 */
	public static void delete(File file){
		if(file.isDirectory()){
			//�Ƚ���������ɾ��
			File[] subs = file.listFiles();
			for(File sub : subs){
				delete(sub);
			}
		}
		file.delete();
	}
}





