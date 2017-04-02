package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List
 * List集合的特点:
 * 有序，并提供了可以通过下标操作元素的相关方法。
 * 常用实现类:
 * ArrayList:数组实现
 * LinkedList:链表实现
 * @author Administrator
 *
 */
public class ListDemo1 {
	public static void main(String[] args) {
		/*
		 * List提供了一对方法:get,set
		 */
		List<String> list 
			= new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		/*
		 * 获取第三个元素
		 * 
		 * E get(int i)
		 * 获取指定位置上的元素
		 */
		String str = list.get(2);
		System.out.println(str);
		
		for(int i=0;i<list.size();i++){
			str = list.get(i);
			System.out.println(str);
		}
		/*
		 * E set(int i,E e)
		 * 将给定元素设置到指定位置上，返回值为
		 * 原位置对应的元素
		 * 替换元素操作
		 * [one,2,three,four]
		 */
		System.out.println(list);
		String old = list.set(1, "2");
		System.out.println(list);
		System.out.println("old:"+old);
	}
}





