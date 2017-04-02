package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 使用新循环比例集合
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
		 * 新循环遍历集合就是迭代器，编译器在将当前
		 * 源码编译为class文件时将新循环改为了使用
		 * 迭代器遍历。所以不要在遍历过程中通过集合
		 * 方法删除元素。
		 */
		for(Object obj : c){
			String str = (String)obj;
			System.out.println(str);
		}
		System.out.println(c);
	}
}





