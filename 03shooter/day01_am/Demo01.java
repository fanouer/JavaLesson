package day14;

public class Demo01 {
	public static void main(String[] args) {
		Demo01 d=new Foo();
		d.f();
	}
	//父类私有方法是不会被子类重写的！
	private void f(){
		System.out.println("Demo01 f()"); 
	}
}
class Foo extends Demo01{
	public void f(){
		System.out.println("Foo  f()"); 
	}
}


