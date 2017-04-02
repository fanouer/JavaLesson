package day10.pm2;

public class Demo09 {
	public static void main(String[] args) {
		/*
		 * 子类构造器会自动调用父类的构造器！
		 */
		new Sub();//HI
	}
}
class Super{
	public Super() {
		System.out.println("HI");
	}
}
class Sub extends Super{
	public Sub(){
		super();//子类构造器调用父类构造器
		System.out.println("HI Sub"); 
	}
}




