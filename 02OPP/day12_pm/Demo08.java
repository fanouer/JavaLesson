package day12;

public class Demo08 {
	public static void main(String[] args) {
		Goo g = new Goo();
		//g.a = 6;
		Dog wangcai = new Dog(8, 2);
		Dog wangwang = new Dog(9, 2);
		//wangcai.id = 6;
		wangcai.age++;
		System.out.println(Dog.numOfDog); 
	}
}
class Dog{
	final int id;
	int age;
	static int numOfDog;
	public Dog(int id, int age) {
		this.id = id;
		this.age = age;
		numOfDog++;
	}
}

/*
 * final ������
 *  1 �����ʼ��
 *    ����ֱ�ӳ�ʼ���������ڹ��������г�ʼ��
 *  2 final�����ԣ�Ҳ��ʵ��������ÿ������һ������
 * final ���� �� static ����
 * static ���� �� ֻ��һ�ݣ������޸�
 * final ���� ÿ��������һ�ݣ������ٴ��޸�
 */
class Goo{
	final int a;
	int b;
	public Goo() {
		a = 7;
	}
}
