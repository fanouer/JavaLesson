package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合间的操作
 * @author Administrator
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c1 = new HashSet();
		c1.add("java");
		c1.add("c");
		c1.add(".net");
		
		Collection c2 = new ArrayList();
		c2.add("c#");
		c2.add("php");
		c2.add(".net");
		/*
		 * boolean addAll(Collection c)
		 * 将给定集合中的所有元素添加到当前集合中
		 * 若添加完毕后当前集合元素发生了变化就会
		 * 返回true 
		 */
		boolean tf = c1.addAll(c2);
		System.out.println(tf+":"+c1);
		
		Collection c3 = new ArrayList();
		c3.add("java");
		c3.add("php");
		/*
		 * boolean contains(Collection c)
		 * 判断当前集合是否包含给定集合中的所有
		 * 元素。
		 */
		boolean contains 
			= c1.containsAll(c3);
		System.out.println("全包含:"+contains);
		
		/*
		 * boolean removeAll(Collection c)
		 * 删除当前集合中与给定集合中共有的元素
		 */
		c1.removeAll(c3);
		System.out.println(c1);
	}
}




