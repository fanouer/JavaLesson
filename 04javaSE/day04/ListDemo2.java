package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List�ṩ��һ��:add,remove����
 * @author Administrator
 *
 */
public class ListDemo2 {
	public static void main(String[] args) {
		List<String> list
			= new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		System.out.println(list);
		
		/*
		 * [one,two,2,three,four]
		 * void add(int i,E e)
		 * ��ָ��λ�ò���ָ��Ԫ��
		 */
		list.add(2, "2");
		System.out.println(list);
		
		/*
		 * E remove(int index)
		 * ɾ��ָ��λ���ϵ�Ԫ�ز����䷵��
		 */
		String old = list.remove(3);
		System.out.println(list);
		System.out.println("old:"+old);
	}
}






