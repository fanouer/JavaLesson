package day09;
/*
 * ���������أ������ص��ù���
 */
public class Demo02 {
	public static void main(String[] args) {
		//���ã��󶨣�����Java���ݲ������͵���
		//���Ӧ�ķ���
		long x = 5, y = 6;
		Foo foo = new Foo();
		//���ݲ�����ֱ�ӵ��� add(long, long)
		long n = foo.add(x, y);
		System.out.println(n); //12
		// ��չ: ���û�ж�Ӧ���͵ķ�����Java
		// ����þ����ܼ򵥷�ʽת���������͵��÷���
		int k = 5;
		long m = 8;
		//Java ��kת��Ϊlong���ͣ�����
		// add(long, long) ����
		long c = foo.add(k, m);
		System.out.println(c);//13
		char ch = 'A';
		int b = 1;
		//���´��룺Java�Ὣchת��Ϊint�Ժ�
		// ���� add(int, int) ����
		int e = foo.add(ch, b);
		System.out.println(e);//67
		
		//long z = foo.add(0, 0.0);
		//System.out.println(z); 
		//���ϴ������н���ǣ�
		// A.�������  B.�����쳣 C.1 D.0
	}
}
class Foo{
	public int add(int a, int b){
		return a+b+1;
	}
	public long add(long a, long b){
		return a+b;
	}
}
 
