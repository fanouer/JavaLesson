package day14;

public class Demo01 {
	public static void main(String[] args) {
		Demo01 d=new Foo();
		d.f();
	}
	//����˽�з����ǲ��ᱻ������д�ģ�
	private void f(){
		System.out.println("Demo01 f()"); 
	}
}
class Foo extends Demo01{
	public void f(){
		System.out.println("Foo  f()"); 
	}
}


