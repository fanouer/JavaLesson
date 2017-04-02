package ioc.set;

public class A {
	private B b;
	private C c;
	public C getC() {
		return c;
	}

	public void setC(C c) {
		System.out.println("A的setC方法");
		this.c = c;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		System.out.println("A的setB方法");
		this.b = b;
	}

	public A() {
		System.out.println("A的无参构造器");
	}
	
	public void execute(){
		b.f1();
		c.f2();
	}
	
	
}
