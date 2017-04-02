package day04;

import java.util.ArrayList;
import java.util.Collection;

import day02.Point;

/**
 * 删除集合元素
 * 删除集合元素也是依靠元素equals的比较结果决定
 * 删除的元素的。
 * @author Administrator
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(7,8));
		c.add(new Point(1,2));
		System.out.println(c);
		Point p = new Point(1,2);
		/*
		 * 只删除集合中第一个与给定元素equals比较
		 * 为true的元素。后面再有则不会被删除
		 */
		c.remove(p);
		System.out.println(c);
	}
}



