package day09;
/*
 * 案例：测试this() 的用法 
 */
public class Demo06 {
	public static void main(String[] args) {
		Circle c = new Circle();
		System.out.println(c.r);//1
	}
}

class Circle {
	int x;
	int y;
	int r;

	public Circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public Circle() {
		//利用this可以重用(主)构造器，减少编码量
		this(0, 0, 1);
	}
}
