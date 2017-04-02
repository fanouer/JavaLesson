package day04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数组转换为集合
 * 依靠数组的工具类Arrays的静态方法asList
 * 需要注意，只能转换为List集合。
 * @author Administrator
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array 
			= {"one","two","three","four"};
		
		List<String> list 
			= Arrays.asList(array);
		System.out.println(
			"size:"+list.size()
		);
		System.out.println(list);
		//不能添加新元素
//		list.add("five");
		//修改现有元素等于修改原数组对应元素
		list.set(1,"2");
		System.out.println(list);
		
		for(String str : array){
			System.out.println(str);
		}
		
		/*
		 * 若想添加新元素要创建新集合:
		 * 所有集合都支持一个参数为Collection的
		 * 构造方法，在创建当前集合的同时可以将指定
		 * 集合中的所有元素包含进来。
		 */
		Set<String> set
			= new HashSet<String>(list);

		System.out.println("new:"+set);
		set.add("five");
		System.out.println("new:"+set);
	}
}







