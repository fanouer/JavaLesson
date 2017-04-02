package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 将集合或Map转换为线程安全的
 * @author Administrator
 *
 */
public class SyncAPIDemo {
	public static void main(String[] args) {
		/*
		 * ArrayList与LinkedList均不是线程安全的
		 */
		List<String> list
			= new ArrayList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		/*
		 * Collections提供了一个静态方法
		 * static List synchronizedList(List list)
		 * 可以将给定的List集合转化为一个线程安全的List
		 * 并且返回的List集合会包含给定集合中的所有元素。
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		/*
		 * HashSet不是线程安全的
		 */
		Set<String> set 
			= new HashSet<String>(list);
		//转换为线程安全的Set集合
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		/*
		 * HashMap也不是线程安全的
		 */
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		//将Map转换为线程安全的
		map = Collections.synchronizedMap(map);
		System.out.println(map);
	}
}





