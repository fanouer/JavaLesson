package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ʹ����ѭ����������
 * @author Administrator
 *
 */
public class NewForDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		/*
		 * ��ѭ���������Ͼ��ǵ��������������ڽ���ǰ
		 * Դ�����Ϊclass�ļ�ʱ����ѭ����Ϊ��ʹ��
		 * ���������������Բ�Ҫ�ڱ���������ͨ������
		 * ����ɾ��Ԫ�ء�
		 */
		for(Object obj : c){
			String str = (String)obj;
			System.out.println(str);
		}
		System.out.println(c);
	}
}





