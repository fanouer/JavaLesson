package day04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ����ת��Ϊ����
 * ��������Ĺ�����Arrays�ľ�̬����asList
 * ��Ҫע�⣬ֻ��ת��ΪList���ϡ�
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
		//���������Ԫ��
//		list.add("five");
		//�޸�����Ԫ�ص����޸�ԭ�����ӦԪ��
		list.set(1,"2");
		System.out.println(list);
		
		for(String str : array){
			System.out.println(str);
		}
		
		/*
		 * ���������Ԫ��Ҫ�����¼���:
		 * ���м��϶�֧��һ������ΪCollection��
		 * ���췽�����ڴ�����ǰ���ϵ�ͬʱ���Խ�ָ��
		 * �����е�����Ԫ�ذ���������
		 */
		Set<String> set
			= new HashSet<String>(list);

		System.out.println("new:"+set);
		set.add("five");
		System.out.println("new:"+set);
	}
}







