package day07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * java.io.ObjectOutputStream
 * �������������һ���߼����������ǿ��Խ�������java
 * ����ת��Ϊһ���ֽں�д����
 * @author Administrator
 *
 */
public class OOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream(
					"person.obj"
			);
		ObjectOutputStream oos
			= new ObjectOutputStream(fos);
		
		Person p = new Person();
		p.setName("����ʦ");
		p.setAge(18);
		p.setGender("Ů");
		List<String> otherInfo
			= new ArrayList<String>();
		otherInfo.add("��һ����Ա");
		otherInfo.add("ͯ��");
		otherInfo.add("ϲ��д����");
		otherInfo.add("�ٽ������Ļ�����");
		p.setOtherInfo(otherInfo);
		/*
		 * void writeObject(Object o)
		 * ���Խ������Ķ���ת��Ϊһ���ֽں�д����
		 */
		oos.writeObject(p);
		
		System.out.println("д�����!");
		
		oos.close();
	}
}








