package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * �����ṩ�˻�ȡ����Ԫ�ص�ͳһ��ʽ:��������
 * ��������ʹ�õ�����ģʽ
 * Iterator�ǵ������ӿڣ��ṩ�˱������ϵ���ط�����
 * ��ͬ�ļ���ʵ���඼������������ϵ�Iteratorʵ����
 * �����סÿһ�ּ��ϵľ�����������֣�ֻҪ������
 * ������(Iterator�ӿڿ���)ʹ�ü���
 * @author Administrator
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");	
		System.out.println(c);
		Iterator it = c.iterator();
		/*
		 * ʹ�õ�������������Ҫ��ѭ��
		 * ��ȡɾ������ɾ�����Ǳ����
		 */
		//��
		while(it.hasNext()){
			//ȡ
			Object obj = it.next();
			String str = (String)obj;
			/*
			 * ��ʹ�õ������������ϵĹ����У�����
			 * ͨ�����ϵķ����޸�Ԫ������
			 */
			if("#".equals(str)){
//				c.remove(str);
				it.remove();
			}
			System.out.println(str);
		}
		System.out.println(c);
		
	}
}






