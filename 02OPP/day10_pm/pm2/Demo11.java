package day10.pm2;

public class Demo11 {
	public static void main(String[] args) {
		//子类对象中是包含父类型对象的实例的。
		Hoo hoo = new Hoo();
		hoo.test();
	}
}

class Goo {
	int a;
	int b;
}

class Hoo extends Goo {
	int c = 4;
	int a = 5;
	/**
	 * this. 是引用, 在运行期间代表调用方法的当前对象。
	 * super. 是引用, 在运行期间代表当前对象的类型对象。
	 */
	public void test() {
		System.out.println(this.c);// 4
		// 在子类和父类中出现了相同属性时候，不能
		// 省略this和super（很少使用的现象！）
		System.out.println(super.a);// 0
		System.out.println(this.a);// 5
	}
}
