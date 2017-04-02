package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序含有自定义元素的List集合
 * @author Administrator
 *
 */
public class SortCollectionDemo1 {
	public static void main(String[] args) {
		List<Point> list
			= new ArrayList<Point>();		
		list.add(new Point(3,4));
		list.add(new Point(1,6));
		list.add(new Point(2,7));
		list.add(new Point(2,1));
		list.add(new Point(8,9));		
		System.out.println(list);
		/*
		 * 集合中的元素必须实现Comparable接口
		 * 
		 * 为了使用Collections.sort方法排序
		 * 集合，它需要我们的元素必须实现Comparable
		 * 接口并重写方法，这种在使用某个功能而需要
		 * 为其改变我们代码的操作称之为"侵入性"
		 * 高侵入性不利于程序扩展。
		 */
		Collections.sort(list);		
		System.out.println(list);
	}
}










