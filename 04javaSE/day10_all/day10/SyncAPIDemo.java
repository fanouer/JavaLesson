package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * �����ϻ�Mapת��Ϊ�̰߳�ȫ��
 * @author Administrator
 *
 */
public class SyncAPIDemo {
	public static void main(String[] args) {
		/*
		 * ArrayList��LinkedList�������̰߳�ȫ��
		 */
		List<String> list
			= new ArrayList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		/*
		 * Collections�ṩ��һ����̬����
		 * static List synchronizedList(List list)
		 * ���Խ�������List����ת��Ϊһ���̰߳�ȫ��List
		 * ���ҷ��ص�List���ϻ�������������е�����Ԫ�ء�
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		/*
		 * HashSet�����̰߳�ȫ��
		 */
		Set<String> set 
			= new HashSet<String>(list);
		//ת��Ϊ�̰߳�ȫ��Set����
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		/*
		 * HashMapҲ�����̰߳�ȫ��
		 */
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		map.put("����", 99);
		map.put("��ѧ", 98);
		map.put("Ӣ��", 97);
		//��Mapת��Ϊ�̰߳�ȫ��
		map = Collections.synchronizedMap(map);
		System.out.println(map);
	}
}





