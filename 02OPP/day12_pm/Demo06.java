package day12;

public class Demo06 {
	public static void main(String[] args) {
		System.out.println("HI"); 
		Koo k = new Koo();
		Koo k2 = new Koo();
	}
}
class Koo{
	static int a = 6;
	/*
	 * ���п���������̬�����
	 *  1�� ��̬����飬��������ڼ�ִ��
	 *    ��ֻ����һ�Σ���̬�����ֻ��ִ��һ��
	 *  2) ʹ�ó��ϣ����ڳ�ʼ����̬��һ������Դ
	 */
	static{
		for(int i=1; i<5; i++){
			System.out.println(a); 
		}
	}
}


