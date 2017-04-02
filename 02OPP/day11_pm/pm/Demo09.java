package day11.pm;

public class Demo09 {
	public static void main(String[] args) {
		Yoo y = new Yoo();
		/*
		 * 此案例用于证明 保护的属性可以在
		 * 子类中直接访问
		 */
		y.test();
	}
}
