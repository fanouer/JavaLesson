package day12;

public class Demo07 {
	public static void main(String[] args) {
		/*
		 * final ���εľֲ�����
		 */
		int a = 5;
		final int b;
		b = 6;//���Գ�ʼ��
		//b = 7;//�������޸ģ�
		final int c = 6;
		//c = 8;//�������޸ģ�
		//final ���Ա������ݱ������޸�
		final int cols = 10;
		
		test(4,5);
		
	}
	
	public static void test(
			final int a, int b){
		//�����ĵĲ��������ڲ�������ʱ����г�ʼ��
		//a = 5;//�������
		b = 6;
		System.out.println(a+","+b);
	}
}










