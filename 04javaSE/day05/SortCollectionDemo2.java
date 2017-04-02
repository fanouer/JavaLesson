package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCollectionDemo2 {
	public static void main(String[] args) {
		List<String> list
			= new ArrayList<String>();
		list.add("小泽老师");
		list.add("苍老师");
		list.add("范老师");
				
		System.out.println(list);	
		/*
		 * 使用重载的sort方法，需要我们额外的传入
		 * 一个比较器(Compartor的实现类)。
		 * 使用这种方式排序可以解决:
		 * 1:元素自身已经实现Comparable并定义了
		 *   比较大小规则，但不满足我们对于排序需求
		 * 2:该sort方法由于使用指定的比较器比较大小，
		 *   所以不要求集合元素必须实现Comparable
		 *   接口，所以对元素没有侵入性。  
		 */
		MyComparator com
			= new MyComparator();		
		Collections.sort(list,com);
		
		System.out.println(list);
	}
}
/**
 * 字符串提供的额外比较规则
 * @author Administrator
 *
 */
class MyComparator implements Comparator<String>{
	/**
	 * 字符串字符多的大
	 */
	public int compare(String o1, String o2) {		
		return o1.length()-o2.length();
	}


	
}









