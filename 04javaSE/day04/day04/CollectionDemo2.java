package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * ���ϼ�Ĳ���
 * @author Administrator
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c1 = new HashSet();
		c1.add("java");
		c1.add("c");
		c1.add(".net");
		
		Collection c2 = new ArrayList();
		c2.add("c#");
		c2.add("php");
		c2.add(".net");
		/*
		 * boolean addAll(Collection c)
		 * �����������е�����Ԫ����ӵ���ǰ������
		 * �������Ϻ�ǰ����Ԫ�ط����˱仯�ͻ�
		 * ����true 
		 */
		boolean tf = c1.addAll(c2);
		System.out.println(tf+":"+c1);
		
		Collection c3 = new ArrayList();
		c3.add("java");
		c3.add("php");
		/*
		 * boolean contains(Collection c)
		 * �жϵ�ǰ�����Ƿ�������������е�����
		 * Ԫ�ء�
		 */
		boolean contains 
			= c1.containsAll(c3);
		System.out.println("ȫ����:"+contains);
		
		/*
		 * boolean removeAll(Collection c)
		 * ɾ����ǰ����������������й��е�Ԫ��
		 */
		c1.removeAll(c3);
		System.out.println(c1);
	}
}




