package day07;

public class Demo {
	public static void main(String[] args) {
		Emp e = new Emp();//创建对象，创建一组变量
		//一个对象，包含一组4个变量
		//对4个变量分别赋值
		e.name = "Tom";
		e.age = 10;
		e.gender = '男';
		e.salary = 1000;
		System.out.println(e.name);
		//以上实验说明：
		//一个Emp对象e 包含一组数据分别是name
		// age gender salary
		
		//利用对象变量好处：可以简化数据的管理
		//可以按照对象（数据组）管理数据。
		
	}
}
/*
 * 声明一个类
 */
class Emp{
	String name;
	int age;
	char gender;
	double salary;
}







