package day14;

public class Demo03 {
	public static void main(String[] args) {
		/*
		 * 匿名内部类：语法及其简洁
		 * new 父类型类名(构造器参数){子类类体}
		 * 没有子类的类名，所以称为匿名内部类
		 * 匿名内部类:语义意义，继承父类并且创
		 * 建了子类型对象。
		 */
		Goo g1 = new Goo(){};//匿名子类对象
		Goo g2 = new Goo();//Goo类型的对象
		//new Hoo();//编译错误不能创建接口的实例
		new Hoo(){};//可以，创建了接口的匿名子类实例
		//匿名内部类：是最“简洁的”接口实现方案
		Hoo hoo = new Hoo(){};
		
		/*
		 * 匿名内部类访问外部方法中的变量数据
		 */
		final int n = 5;
		int m = 6;
		Xoo x = new Xoo(){
			public void test(){
				//访问外部的final局部变量
				System.out.println(n);
				//System.out.println(m);
			}
		};
		x.test();
	}
}
interface Xoo{
	void test();
}

interface Hoo{
}
/*
 * 声明Goo作为匿名内部类的父类型
 */
class Goo{
}





