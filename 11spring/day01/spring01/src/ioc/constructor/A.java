package ioc.constructor;

public class A {
	private B b;
	
	public A(B b) {
		System.out.println("A的带参构造器");
		this.b = b;
	}

	public void execute(){
		b.f1();
	}
}
