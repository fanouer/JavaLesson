package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合提供了获取集合元素的统一方式:遍历集合
 * 遍历集合使用迭代器模式
 * Iterator是迭代器接口，提供了遍历集合的相关方法。
 * 不同的集合实现类都有自身遍历集合的Iterator实现类
 * 无需记住每一种集合的具体迭代器名字，只要当做是
 * 迭代器(Iterator接口看待)使用即可
 * @author Administrator
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");	
		System.out.println(c);
		Iterator it = c.iterator();
		/*
		 * 使用迭代器遍历集合要遵循：
		 * 问取删，其中删除不是必须的
		 */
		//问
		while(it.hasNext()){
			//取
			Object obj = it.next();
			String str = (String)obj;
			/*
			 * 在使用迭代器遍历集合的过程中，不得
			 * 通过集合的方法修改元素数量
			 */
			if("#".equals(str)){
//				c.remove(str);
				it.remove();
			}
			System.out.println(str);
		}
		System.out.println(c);
		
	}
}






