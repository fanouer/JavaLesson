package day11.pm;

public class Demo07 {
	public static void main(String[] args) {
		/*
		 * ��ͬһ����(package)�п���ֱ��ʹ��
		 * ͬ����������
		 */
		Point p = new Point(3, 4);
		/*
		 * ˽�����Բ��ܷ���
		 */
		//System.out.println(p.x); 
		p.test();
		/*
		 * �������Կ��Խ�������Ķ�д
		 */
		System.out.println(p.z);
		p.z = 100;
		System.out.println(p.z); 
		/*
		 * Demo07 �� Point ����ͬһ������ day11.pm
		 * Demo07 ���Է���Point��t����
		 */
		System.out.println(p.t); 
	}
}





