package day06;
//��������ʾ
public class MethodDemo {
	public static void main(String[] args) {
		//say();
		//say();
		
		//sayHi(); //������󣬱��봫��
		//sayHi(25); //������󣬲������Ͳ�ƥ��
		//sayHi("zhangsan"); //String name="zhangsan"
		//sayHi("lisi"); //String name="lisi";
		
		//double a = getNum(); //getNum()��ֵ����return����Ǹ�ֵ
		//System.out.println(a); //8.88
		
		
		
		//111,333,444,222
		//a(); //������Ƕ�׵���
		
		//int b = plus(5,6); //int num1=5,int num2=6
		//System.out.println(b); //11
		
		int m=5,n=6;
		int nu = plus(m,n); //int num1=5,int num2=6;
		System.out.println(nu);
		
		System.out.println("over");
	}
	
	//�в��з���ֵ
	public static int plus(int num1,int num2){
		int result = num1+num2;
		return result; //���ص���result�е�ֵ
		//return num1+num2;
	}
	
	//�޲��з���ֵ
	public static double getNum(){
		//return; //������󣬱��뷵��һ��ֵ
		//return "hi"; //������󣬷���ֵ���Ͳ�ƥ��
		return 8.88; //1.��������  2.����һ����������÷�
	}
	
	//�в��޷���ֵ
	public static void sayHi(String name){
		System.out.println("��Һã��ҽ�"+name);
	}
	
	//�޲��޷���ֵ
	public static void say(){
		System.out.println("��Һã��ҽ�WKJ");
		return; //1.��������---ʵ���÷�������õ�
	}
	
	
	public static void a(){
		System.out.println(111);
		b();
		System.out.println(222);
	}
	public static void b(){
		System.out.println(333);
		c();
	}
	public static void c(){
		System.out.println(444);
	}
}












