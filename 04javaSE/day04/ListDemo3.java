package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List�ṩ�˻�ȡ�Ӽ��ķ���
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
		 * ��ȡָ����Χ�ڵ�Ԫ��
		 * ��ȡ3-7
		 */
		List<Integer> subList
			= list.subList(3, 8);
		System.out.println(subList);
		
		/*
		 * ���Ӽ�Ԫ������10��
		 */
		for(int i=0;i<subList.size();i++){
			int num = subList.get(i);
			num = num * 10;
			subList.set(i,num);
		}
		System.out.println(subList);
		/*
		 * ���Ӽ����޸Ļ�Ӱ��ԭ����
		 */
		System.out.println(list);
		
		/*
		 * ɾ��3-8
		 */
		list.subList(3, 9).clear();
		System.out.println(list);
		
	}
}






