package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * �����ڼ����е�Ӧ��������Լ������Ԫ������
 * @author Administrator
 *
 */
public class CollectionDemo4 {
	public static void main(String[] args) {
		Collection<String> c 
			= new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		
		for(String str :c){
			System.out.println(str);
		}
		/*
		 * �������ķ���Ӧ����������ļ��ϵķ���
		 * ����һ��
		 */
		Iterator<String> it = c.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		
	}
}





