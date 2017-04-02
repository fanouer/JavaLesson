package day06;
//方法的演示
public class MethodDemo {
	public static void main(String[] args) {
		//say();
		//say();
		
		//sayHi(); //编译错误，必须传参
		//sayHi(25); //编译错误，参数类型不匹配
		//sayHi("zhangsan"); //String name="zhangsan"
		//sayHi("lisi"); //String name="lisi";
		
		//double a = getNum(); //getNum()的值就是return后的那个值
		//System.out.println(a); //8.88
		
		
		
		//111,333,444,222
		//a(); //方法的嵌套调用
		
		//int b = plus(5,6); //int num1=5,int num2=6
		//System.out.println(b); //11
		
		int m=5,n=6;
		int nu = plus(m,n); //int num1=5,int num2=6;
		System.out.println(nu);
		
		System.out.println("over");
	}
	
	//有参有返回值
	public static int plus(int num1,int num2){
		int result = num1+num2;
		return result; //返回的是result中的值
		//return num1+num2;
	}
	
	//无参有返回值
	public static double getNum(){
		//return; //编译错误，必须返回一个值
		//return "hi"; //编译错误，返回值类型不匹配
		return 8.88; //1.结束方法  2.返回一个结果给调用方
	}
	
	//有参无返回值
	public static void sayHi(String name){
		System.out.println("大家好，我叫"+name);
	}
	
	//无参无返回值
	public static void say(){
		System.out.println("大家好，我叫WKJ");
		return; //1.结束方法---实际用法后面会用到
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












