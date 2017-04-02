package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供了一对:add,remove方法
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
		 * 向指定位置插入指定元素
		 */
		list.add(2, "2");
		System.out.println(list);
		
		/*
		 * E remove(int index)
		 * 删除指定位置上的元素并将其返回
		 */
		String old = list.remove(3);
		System.out.println(list);
		System.out.println("old:"+old);
	}
}






