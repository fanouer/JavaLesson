package day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 遍历Map 遍历Map有三种方式: 遍历所有的key 遍历所有的key-value对 遍历所有的value(相对不常用)
 * 
 * @author Administrator
 * 
 */
public class MapDemo2 {
	public static void main(String[] args) {
		/*
		 * 若希望存取顺序一致(存放顺序与遍历顺序)
		 * 可以使用LinkedHashMap
		 */
		Map<String, Integer> map 
			= new HashMap<String, Integer>();
		map.put("语文", 98);
		map.put("数学", 97);
		map.put("英语", 96);
		map.put("物理", 95);
		map.put("化学", 94);		
		/*
		 * 遍历所有的key
		 * Set<K> keySet()
		 * 将当前Map中所有的key存入一个Set集合
		 * 中然后返回。
		 */
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println("key:"+key);
		}
		
		/*
		 * 遍历每一组键值对
		 * Set<Entry> entrySet()
		 * 将Map中每一组key-value对以一个Entry的
		 * 实例保存，然后将若干Entry实例存入Set集合
		 * 后返回
		 * Entry是Map的内部类，每一个实例表示一组
		 * 键值对
		 */
		Set<Entry<String,Integer>> entrySet 
								= map.entrySet();
		for(Entry<String,Integer> e:entrySet){
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
		
		/*
		 * 遍历所有的value
		 * Collection<V> values()
		 * 将当前Map中所有的value存入一个集合后
		 * 返回。
		 */
		Collection<Integer> values = map.values();
		for(Integer v : values){
			System.out.println(v);
		}
	}
}




