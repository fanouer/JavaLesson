package day09;
/*
 * ����������this() ���÷� 
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
		//����this��������(��)�����������ٱ�����
		this(0, 0, 1);
	}
}
