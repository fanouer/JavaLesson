package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCollectionDemo2 {
	public static void main(String[] args) {
		List<String> list
			= new ArrayList<String>();
		list.add("С����ʦ");
		list.add("����ʦ");
		list.add("����ʦ");
				
		System.out.println(list);	
		/*
		 * ʹ�����ص�sort��������Ҫ���Ƕ���Ĵ���
		 * һ���Ƚ���(Compartor��ʵ����)��
		 * ʹ�����ַ�ʽ������Խ��:
		 * 1:Ԫ�������Ѿ�ʵ��Comparable��������
		 *   �Ƚϴ�С���򣬵����������Ƕ�����������
		 * 2:��sort��������ʹ��ָ���ıȽ����Ƚϴ�С��
		 *   ���Բ�Ҫ�󼯺�Ԫ�ر���ʵ��Comparable
		 *   �ӿڣ����Զ�Ԫ��û�������ԡ�  
		 */
		MyComparator com
			= new MyComparator();		
		Collections.sort(list,com);
		
		System.out.println(list);
	}
}
/**
 * �ַ����ṩ�Ķ���ȽϹ���
 * @author Administrator
 *
 */
class MyComparator implements Comparator<String>{
	/**
	 * �ַ����ַ���Ĵ�
	 */
	public int compare(String o1, String o2) {		
		return o1.length()-o2.length();
	}


	
}









