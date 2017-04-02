package day09;
/*
 * 方法的重载，和重载调用规则
 */
public class Demo02 {
	public static void main(String[] args) {
		//调用（绑定）规则：Java根据参数类型调用
		//向对应的方法
		long x = 5, y = 6;
		Foo foo = new Foo();
		//根据参数类直接调用 add(long, long)
		long n = foo.add(x, y);
		System.out.println(n); //12
		// 扩展: 如果没有对应类型的方法，Java
		// 会采用尽可能简单方式转换数据类型调用方法
		int k = 5;
		long m = 8;
		//Java 将k转换为long类型，调用
		// add(long, long) 方法
		long c = foo.add(k, m);
		System.out.println(c);//13
		char ch = 'A';
		int b = 1;
		//如下代码：Java会将ch转换为int以后
		// 调用 add(int, int) 方法
		int e = foo.add(ch, b);
		System.out.println(e);//67
		
		//long z = foo.add(0, 0.0);
		//System.out.println(z); 
		//如上代码运行结果是：
		// A.编译错误  B.运行异常 C.1 D.0
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
 
