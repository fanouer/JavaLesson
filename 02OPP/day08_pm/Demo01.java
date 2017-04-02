package day08;

public class Demo01 {
	public static void main(String[] args) {
		//调用构造器创建对象
		//声明了变量a1引用了飞机对象
		Airplane a1 = new Airplane();
		System.out.println(a1.x);
		System.out.println(a1.y);
		System.out.println(a1.w);
		System.out.println(a1.h);
		//调用飞方法
		a1.move();
		//测试飞翔以后的数据
		System.out.println(a1.x);
		System.out.println(a1.y);
		System.out.println(a1.w);
		System.out.println(a1.h);
	}
}

class Airplane {
	int w;
	int h;
	int x;
	int y;

	// 第一次创建飞机时候调用构造器
	public Airplane() {
		w = 38;
		h = 62;
		y = -h;
		x = (int) (Math.random() * (480 - w));// 0~(480-w)
	}

	// 飞行方法
	public void move() {
		y++;
	}

}
