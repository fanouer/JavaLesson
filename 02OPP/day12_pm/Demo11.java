package day12;

public class Demo11 {
	public static void main(String[] args) {
		/*
		 * ���������������������ʵ����
		 */
		//Shape s = new Shape();
		/*
		 * ����������������������þ������͵Ķ���
		 */
		Circle c = new Circle(10);
		Square s = new Square(10);
		System.out.println(c.area());
		System.out.println(s.area());
		
		Shape ss = c;
		ss = s;
		//��̬����
		
		
		
	}
}
/*
 * ������
 */
class Square extends Shape{
	public Square(double c) {
		this.c = c;
	}
	public double area(){
		double d = c/4;
		return d*d;
	}
}
/*
 * �ӳ�����̳о������ࡣ
 * �����������ʵ�֣���д���������еĳ��󷽷���
 */
class Circle extends Shape{
	public Circle(double c) {
		this.c = c;//��ʼ��Բ���ܳ�
	}
	/*
	 * ��д�����еĳ��󷽷�
	 */
	public double area(){
		double r = c/3.1415926535897932/2;
		return Math.PI * r * r;
	}
}
/*
 * ��������ͼ��
 * abstract �ؼ��ֿ������ƣ���������
 * ���Ա��ⴴ�������������ʵ��������Ӱ������Ŀɿ���
 * ������������Ϊ�̳и��࣬��������̳У�����
 * �������Ժͷ����ģ�
 */
abstract class Shape{
	/*
	 * ��ʾͼ�ε��ܳ�
	 */
	protected double c;
	/*
	 * ����ͼ������ķ���
	 * ������һ���ķ����������޷�ȷ���㷨�ķ���
	 * ���Զ���Ϊ���󷽷�!
	 */
	public abstract double area();
}







