package day12;

public class Demo10 {
	public static void main(String[] args) {
		/*
		 * Java�еĳ����ڱ���ʱ�򱻡����������滻Ϊ
		 * �����������ֵ���������´�������ʱ��
		 * Java��������࣬����ִ�о�̬�����
		 */
		System.out.println(Hoo.NUM);//100
	}
}
class Hoo{
	public static final int NUM = 100;
	static{
		System.out.println("����Hoo"); 
	}
}