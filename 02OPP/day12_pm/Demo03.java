package day12;

public class Demo03 {
	public static void main(String[] args) {
		Cat tom = new Cat(4);
		Cat kitty = new Cat(3);
		/*
		 * һ�������ʹ�� �������ʾ�̬����
		 */
		System.out.println(Cat.numOfCats);
	}
}
class Cat{
	private int age;
	public static int numOfCats;
	public Cat(int age) {
		this.age = age;
		/*
		 * ���ö��è����ġ�һ�ݡ���̬����numOfCats
		 * ͳ�ƴ���è���������
		 */
		Cat.numOfCats++;
		System.out.println(Cat.numOfCats); 
	}
}





