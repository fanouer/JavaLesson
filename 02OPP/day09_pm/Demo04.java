package day09;

public class Demo04 {
	public static void main(String[] args) {
		Goo goo = new Goo();//调用默认构造器
		//Koo koo = new Koo();//编译错，没有Koo()
		Koo k = new Koo(8);//调用有参数构造器
	}
}
class Goo{
	//Java编译器自动添加默认构造器 Goo()
}
class Koo{
	public Koo(int n){
	}
}

