package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection�ṩ��һ������toArray
 * ���Խ����еļ���ת��Ϊ����
 * @author Administrator
 *
 */
public class CollectionToArray {
	public static void main(String[] args) {
		Collection<String> c
			= new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		
//		Object[] array = c.toArray();
		
		String[] array 
			= c.toArray(new String[c.size()]);
		System.out.println(array.length);
		for(String str : array){
			System.out.println(str);
		}
		
	}
}







