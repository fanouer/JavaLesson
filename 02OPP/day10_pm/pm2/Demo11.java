package day10.pm2;

public class Demo11 {
	public static void main(String[] args) {
		//����������ǰ��������Ͷ����ʵ���ġ�
		Hoo hoo = new Hoo();
		hoo.test();
	}
}

class Goo {
	int a;
	int b;
}

class Hoo extends Goo {
	int c = 4;
	int a = 5;
	/**
	 * this. ������, �������ڼ������÷����ĵ�ǰ����
	 * super. ������, �������ڼ����ǰ��������Ͷ���
	 */
	public void test() {
		System.out.println(this.c);// 4
		// ������͸����г�������ͬ����ʱ�򣬲���
		// ʡ��this��super������ʹ�õ����󣡣�
		System.out.println(super.a);// 0
		System.out.println(this.a);// 5
	}
}
