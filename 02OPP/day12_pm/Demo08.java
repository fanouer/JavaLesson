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
 * final 的属性
 *  1 必须初始化
 *    可以直接初始化，或者在构造器进行初始化
 *  2 final的属性，也是实例变量，每个对象一个变量
 * final 属性 与 static 属性
 * static 属性 是 只有一份，可以修改
 * final 属性 每个对象有一份，不可再次修改
 */
class Goo{
	final int a;
	int b;
	public Goo() {
		a = 7;
	}
}
