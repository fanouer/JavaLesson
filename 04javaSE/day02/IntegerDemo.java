package day02;
/**
 * �������Ͳ���������󿪷�
 * @author Administrator
 *
 */
public class IntegerDemo {
	public static void main(String[] args) {
		int a = 1;
		//����������ת��Ϊ��װ��
		Integer i1 = new Integer(a);
		//�Ƽ�ʹ��valueOf����ת��Ϊ��װ��
		Integer i2 = Integer.valueOf(a);
		
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
		
		
		/*
		 * �����������Ͱ�װ�඼�̳���Number
		 * �����ඨ���˿����ڼ����������ͼ�ת��
		 * �ķ�����
		 */
		Double d = Double.valueOf(128.123);
		double dou = d.doubleValue();
		System.out.println("d:"+dou);
		
		int in = d.intValue();
		System.out.println("i:"+in);
		
		byte b = d.byteValue();
		System.out.println("b:"+b);
		
		/*
		 * �������Ͱ�װ������������:
		 * MAX_VALUE:��Ӧ�����������ֵ
		 * MIN_VALUE:��Ӧ����������Сֵ
		 */
		//int���ֵ?
		int max = Integer.MAX_VALUE;
		System.out.println("imax:"+max);
		int min = Integer.MIN_VALUE;
		System.out.println("imin:"+min);
		
		long lmax = Long.MAX_VALUE;
		
	}
	
}











