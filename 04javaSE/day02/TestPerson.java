package day02;

public class TestPerson {
	public static void main(String[] args) {
		Point p = new Point(1,2);
		/*
		 * JAVA API�ṩ����󲿷ֶ���д��toString
		 * ���ǵ�������Ҫ���������Լ���������
		 * toString����ʱ����Ӧ����д����
		 * ��ΪObject����ĸ÷������ص��ַ�����
		 * ����ĵ�ַ��û��ʲôʵ�����塣
		 */
		String str = p.toString();
		System.out.println(str);
		/*
		 * System.out.println(Object o)
		 * �÷������������̨���һ�ж��������
		 * �Ǹ�������toString()�������ص��ַ���
		 */
		System.out.println(p);
		
		
		Point p1 = new Point(1,2);
		
		System.out.println(p==p1);//false
		System.out.println(p.equals(p1));//true
		
		
	}
}





