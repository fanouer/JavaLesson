package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供了获取子集的方法
 * @author Administrator
 *
 */
public class ListDemo3 {
	public static void main(String[] args) {
		List<Integer> list
			= new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list);
		
		/*
		 * List subList(int start,int end)
		 * 获取指定范围内的元素
		 * 获取3-7
		 */
		List<Integer> subList
			= list.subList(3, 8);
		System.out.println(subList);
		
		/*
		 * 对子集元素扩大10倍
		 */
		for(int i=0;i<subList.size();i++){
			int num = subList.get(i);
			num = num * 10;
			subList.set(i,num);
		}
		System.out.println(subList);
		/*
		 * 对子集的修改会影响原集合
		 */
		System.out.println(list);
		
		/*
		 * 删除3-8
		 */
		list.subList(3, 9).clear();
		System.out.println(list);
		
	}
}






