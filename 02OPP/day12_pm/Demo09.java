package day12;

public class Demo09 {
	public static void main(String[] args) {
	
	}
}
class Super{
	public void f1(){
	}
	public final void f2(){
	}
}
class Sub extends Super{
	public void f1() {
	}
	/*
	 * 子类中不能重写 父类中 final的方法！
	 * 可以保护 父类在声明的算法，避免被子类修改！
	 */
	//public void f2(){
	//}
}




