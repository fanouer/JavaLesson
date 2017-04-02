package day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ����Map ����Map�����ַ�ʽ: �������е�key �������е�key-value�� �������е�value(��Բ�����)
 * 
 * @author Administrator
 * 
 */
public class MapDemo2 {
	public static void main(String[] args) {
		/*
		 * ��ϣ����ȡ˳��һ��(���˳�������˳��)
		 * ����ʹ��LinkedHashMap
		 */
		Map<String, Integer> map 
			= new HashMap<String, Integer>();
		map.put("����", 98);
		map.put("��ѧ", 97);
		map.put("Ӣ��", 96);
		map.put("����", 95);
		map.put("��ѧ", 94);		
		/*
		 * �������е�key
		 * Set<K> keySet()
		 * ����ǰMap�����е�key����һ��Set����
		 * ��Ȼ�󷵻ء�
		 */
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println("key:"+key);
		}
		
		/*
		 * ����ÿһ���ֵ��
		 * Set<Entry> entrySet()
		 * ��Map��ÿһ��key-value����һ��Entry��
		 * ʵ�����棬Ȼ������Entryʵ������Set����
		 * �󷵻�
		 * Entry��Map���ڲ��࣬ÿһ��ʵ����ʾһ��
		 * ��ֵ��
		 */
		Set<Entry<String,Integer>> entrySet 
								= map.entrySet();
		for(Entry<String,Integer> e:entrySet){
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
		
		/*
		 * �������е�value
		 * Collection<V> values()
		 * ����ǰMap�����е�value����һ�����Ϻ�
		 * ���ء�
		 */
		Collection<Integer> values = map.values();
		for(Integer v : values){
			System.out.println(v);
		}
	}
}




