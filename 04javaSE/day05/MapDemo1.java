package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map
 * 以key-value对的形式存储元素
 * 常用实现类:HashMap
 * 查询速度比数组快
 * @author Administrator
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer> map 
			= new HashMap<String,Integer>();
		
		/*
		 * V put(K k,V v)
		 * 将指定的key-value对存入到Map中。
		 * Map有一个要求，key不允许重复(equals)
		 * 若以Map现有的key存入一个新的value时，
		 * 则是替换value,put方法返回的即是被替换
		 * 的value，否则返回值为null。
		 */
		map.put("语文", 98);
		map.put("数学", 97);
		map.put("英语", 96);
		map.put("物理", 95);
		map.put("化学", 94);
		
		System.out.println(map);
		
		Integer num = map.put("化学", 93);
		System.out.println(num);
		System.out.println(map);
		
		/*
		 * V get(K k)
		 * 获取给定的key所对应的value
		 * 若指定的key在当前Map中不存在则返回null
		 */
		num = map.get("语文");
		System.out.println("语文:"+num);
		
		num = map.get("体育");
		System.out.println("体育:"+num);
		
		/*
		 * boolean containsKey(K k)
		 * 判断当前Map是否包含指定的key
		 * 
		 * boolean containsValue(V v)
		 * 判断当前Map是否包含指定的value
		 * 
		 * 判断也是依靠元素equals方法比较的
		 */
		boolean ck = map.containsKey("美术");
		System.out.println("包含:"+ck);
	}
}









