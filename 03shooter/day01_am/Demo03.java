package day14;

public class Demo03 {
	public static void main(String[] args) {
		/*
		 * �����ڲ��ࣺ�﷨������
		 * new ����������(����������){��������}
		 * û����������������Գ�Ϊ�����ڲ���
		 * �����ڲ���:�������壬�̳и��ಢ�Ҵ�
		 * ���������Ͷ���
		 */
		Goo g1 = new Goo(){};//�����������
		Goo g2 = new Goo();//Goo���͵Ķ���
		//new Hoo();//��������ܴ����ӿڵ�ʵ��
		new Hoo(){};//���ԣ������˽ӿڵ���������ʵ��
		//�����ڲ��ࣺ������ġ��ӿ�ʵ�ַ���
		Hoo hoo = new Hoo(){};
		
		/*
		 * �����ڲ�������ⲿ�����еı�������
		 */
		final int n = 5;
		int m = 6;
		Xoo x = new Xoo(){
			public void test(){
				//�����ⲿ��final�ֲ�����
				System.out.println(n);
				//System.out.println(m);
			}
		};
		x.test();
	}
}
interface Xoo{
	void test();
}

interface Hoo{
}
/*
 * ����Goo��Ϊ�����ڲ���ĸ�����
 */
class Goo{
}





