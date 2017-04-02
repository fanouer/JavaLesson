package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection提供了一个方法toArray
 * 可以将现有的集合转换为数组
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







