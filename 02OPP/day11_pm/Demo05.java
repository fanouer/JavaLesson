package day11;

public class Demo05 {
	public static void main(String[] args) {
		Super obj = new Sub();
		Goo goo = new Goo();
		goo.g(obj);   
	}
}

class Super {
	public void f() {
		System.out.println("super.f()");
	}
}

class Sub extends Super {
	public void f() {
		System.out.println("sub.f()");
	}
}

class Goo {
	public void g(Super obj) {
		System.out.println("g(Super)");
		obj.f();
	}

	public void g(Sub obj) {
		System.out.println("g(Sub) ");
		obj.f();
	}
}
