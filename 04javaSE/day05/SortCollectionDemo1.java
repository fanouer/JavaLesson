package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * �������Զ���Ԫ�ص�List����
 * @author Administrator
 *
 */
public class SortCollectionDemo1 {
	public static void main(String[] args) {
		List<Point> list
			= new ArrayList<Point>();		
		list.add(new Point(3,4));
		list.add(new Point(1,6));
		list.add(new Point(2,7));
		list.add(new Point(2,1));
		list.add(new Point(8,9));		
		System.out.println(list);
		/*
		 * �����е�Ԫ�ر���ʵ��Comparable�ӿ�
		 * 
		 * Ϊ��ʹ��Collections.sort��������
		 * ���ϣ�����Ҫ���ǵ�Ԫ�ر���ʵ��Comparable
		 * �ӿڲ���д������������ʹ��ĳ�����ܶ���Ҫ
		 * Ϊ��ı����Ǵ���Ĳ�����֮Ϊ"������"
		 * �������Բ����ڳ�����չ��
		 */
		Collections.sort(list);		
		System.out.println(list);
	}
}










