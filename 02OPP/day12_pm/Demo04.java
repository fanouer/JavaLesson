package day12;

public class Demo04 {
	public static void main(String[] args) {
		Foo.test();//���þ�̬���� ������û��this
		Foo foo = new Foo();
		foo.f();//���ö���ķ�������������this
	}
}
class Foo{
	int a = 5;
	public static void test() {
		System.out.println("test()");
		/*
		 * ��̬������û��this���������ܷ���
		 * ��ǰ��������ԡ����� 
		 */
		//System.out.println(this.a);//�����
	}
	public void f(){
		System.out.println("f()");
		System.out.println(this.a);
	}
}


