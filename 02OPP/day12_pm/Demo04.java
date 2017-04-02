package day12;

public class Demo04 {
	public static void main(String[] args) {
		Foo.test();//调用静态方法 方法中没有this
		Foo foo = new Foo();
		foo.f();//调用对象的方法，方法中有this
	}
}
class Foo{
	int a = 5;
	public static void test() {
		System.out.println("test()");
		/*
		 * 静态方法中没有this变量，不能访问
		 * 当前对象的属性、方法 
		 */
		//System.out.println(this.a);//编译错
	}
	public void f(){
		System.out.println("f()");
		System.out.println(this.a);
	}
}


