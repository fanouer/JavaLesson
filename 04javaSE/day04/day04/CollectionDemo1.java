package day04;

import java.util.ArrayList;
import java.util.Collection;

import day02.Point;

/**
 * ɾ������Ԫ��
 * ɾ������Ԫ��Ҳ������Ԫ��equals�ıȽϽ������
 * ɾ����Ԫ�صġ�
 * @author Administrator
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(7,8));
		c.add(new Point(1,2));
		System.out.println(c);
		Point p = new Point(1,2);
		/*
		 * ֻɾ�������е�һ�������Ԫ��equals�Ƚ�
		 * Ϊtrue��Ԫ�ء����������򲻻ᱻɾ��
		 */
		c.remove(p);
		System.out.println(c);
	}
}



