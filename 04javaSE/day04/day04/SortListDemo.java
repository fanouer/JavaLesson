package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 对List集合进行自然排序
 * 使用的是集合的工具类Collections的静态方法sort
 * @author Administrator
 *
 */
public class SortListDemo {
	public static void main(String[] args) {
		List<Integer> list
			= new ArrayList<Integer>();
		
		Random random = new Random();
		
		for(int i=0;i<10;i++){
			list.add(random.nextInt(100));
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}





