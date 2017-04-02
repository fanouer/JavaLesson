package day07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * java.io.ObjectInputStream
 * ������һ���߼��������ڶ�ȡһ������
 * ��Ҫע����ǣ�ʹ�ø�����ȡ���ֽڣ�Ӧ������
 * ObjectOutputStream������ת�����ֽڲſ��ԡ�
 * ������׳��쳣:ClassNotFoundException
 * @author Administrator
 *
 */
public class OISDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis
			= new FileInputStream(
				"person.obj"
			);
		
		ObjectInputStream ois
			= new ObjectInputStream(fis);
		
		Person p = (Person)ois.readObject();
		
		System.out.println(p);
		
		ois.close();
	}
}





