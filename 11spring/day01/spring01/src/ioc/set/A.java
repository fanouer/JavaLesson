package ioc.set;

public class A {
	private B b;
	private C c;
	public C getC() {
		return c;
	}

	public void setC(C c) {
		System.out.println("A��setC����");
		this.c = c;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		System.out.println("A��setB����");
		this.b = b;
	}

	public A() {
		System.out.println("A���޲ι�����");
	}
	
	public void execute(){
		b.f1();
		c.f2();
	}
	
	
}
