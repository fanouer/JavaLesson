package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map
 * ��key-value�Ե���ʽ�洢Ԫ��
 * ����ʵ����:HashMap
 * ��ѯ�ٶȱ������
 * @author Administrator
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer> map 
			= new HashMap<String,Integer>();
		
		/*
		 * V put(K k,V v)
		 * ��ָ����key-value�Դ��뵽Map�С�
		 * Map��һ��Ҫ��key�������ظ�(equals)
		 * ����Map���е�key����һ���µ�valueʱ��
		 * �����滻value,put�������صļ��Ǳ��滻
		 * ��value�����򷵻�ֵΪnull��
		 */
		map.put("����", 98);
		map.put("��ѧ", 97);
		map.put("Ӣ��", 96);
		map.put("����", 95);
		map.put("��ѧ", 94);
		
		System.out.println(map);
		
		Integer num = map.put("��ѧ", 93);
		System.out.println(num);
		System.out.println(map);
		
		/*
		 * V get(K k)
		 * ��ȡ������key����Ӧ��value
		 * ��ָ����key�ڵ�ǰMap�в������򷵻�null
		 */
		num = map.get("����");
		System.out.println("����:"+num);
		
		num = map.get("����");
		System.out.println("����:"+num);
		
		/*
		 * boolean containsKey(K k)
		 * �жϵ�ǰMap�Ƿ����ָ����key
		 * 
		 * boolean containsValue(V v)
		 * �жϵ�ǰMap�Ƿ����ָ����value
		 * 
		 * �ж�Ҳ������Ԫ��equals�����Ƚϵ�
		 */
		boolean ck = map.containsKey("����");
		System.out.println("����:"+ck);
	}
}









