package day10.pm2;

public class Demo09 {
	public static void main(String[] args) {
		/*
		 * ���๹�������Զ����ø���Ĺ�������
		 */
		new Sub();//HI
	}
}
class Super{
	public Super() {
		System.out.println("HI");
	}
}
class Sub extends Super{
	public Sub(){
		super();//���๹�������ø��๹����
		System.out.println("HI Sub"); 
	}
}




