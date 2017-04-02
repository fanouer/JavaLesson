package day09;

public class Demo05 {
	public static void main(String[] args) {
		//调用重载的构造器: 
		Rect r1 = new Rect(3,4);
		// . 是运算符：取成员运算符，理解为“的”
		//  表示所属关系		
		System.out.println(r1.width);//3
		System.out.println(r1.height);//4
		
		Rect r2 = new Rect(5);
		System.out.println(r2.width);//5
		System.out.println(r2.height);
		
		Rect r3 = new Rect();
		System.out.println(r3.width);//1
		System.out.println(r3.height);//1
		
		//System.out.println(r3);
	}
}
class Rect{
	int width; int height;
	public Rect(int w, int h) {
		width = w; height = h;
	}
	public Rect(int w){
		width = w; height = w;
	}
	public Rect(){
		width = 1; height = 1;
	}
}
