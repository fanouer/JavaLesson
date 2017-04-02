package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List
 * List���ϵ��ص�:
 * ���򣬲��ṩ�˿���ͨ���±����Ԫ�ص���ط�����
 * ����ʵ����:
 * ArrayList:����ʵ��
 * LinkedList:����ʵ��
 * @author Administrator
 *
 */
public class ListDemo1 {
	public static void main(String[] args) {
		/*
		 * List�ṩ��һ�Է���:get,set
		 */
		List<String> list 
			= new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		/*
		 * ��ȡ������Ԫ��
		 * 
		 * E get(int i)
		 * ��ȡָ��λ���ϵ�Ԫ��
		 */
		String str = list.get(2);
		System.out.println(str);
		
		for(int i=0;i<list.size();i++){
			str = list.get(i);
			System.out.println(str);
		}
		/*
		 * E set(int i,E e)
		 * ������Ԫ�����õ�ָ��λ���ϣ�����ֵΪ
		 * ԭλ�ö�Ӧ��Ԫ��
		 * �滻Ԫ�ز���
		 * [one,2,three,four]
		 */
		System.out.println(list);
		String old = list.set(1, "2");
		System.out.println(list);
		System.out.println("old:"+old);
	}
}





