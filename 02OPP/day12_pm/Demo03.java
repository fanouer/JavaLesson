package day12;

public class Demo03 {
	public static void main(String[] args) {
		Cat tom = new Cat(4);
		Cat kitty = new Cat(3);
		/*
		 * 一般情况下使用 类名访问静态属性
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
		 * 利用多个猫共享的“一份”静态变量numOfCats
		 * 统计创建猫对象的数量
		 */
		Cat.numOfCats++;
		System.out.println(Cat.numOfCats); 
	}
}





