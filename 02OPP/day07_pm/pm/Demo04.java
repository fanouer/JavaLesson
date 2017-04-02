package day07.pm;
/*
 * 比较使用对象和不使用对象代码的差别
 * 
 * 业务功能， 打印员工信息
 *  1 简单变量版本
 *  2 对象版本
 */
public class Demo04 {
	public static void main(String[] args) {
		//如下一组变量代表 一个员工的信息
		String name = "tom";
		int age = 10;
		char gender = '男';
		double salary = 1000;
		//第二个员工信息
		String name1 = "jerry";
		int age1 = 5;
		char gender1 = '男';
		double salary1 = 3000;
		//打印员工信息:
		print(name, age, gender, salary);
		//打印员工信息
		print(name1, age1, gender1, salary1);
		//System.out.println("姓名:"+name1);
		//System.out.println("年龄:"+age1);
		//System.out.println("性别:"+gender1);
		//System.out.println("薪水:"+salary1);
		
		//重构为 用对象代表组员工数据
		// 每个对象都是一组 4个数据
		// 每个对象中的数据，称为对象的属性
		// 对象属性=实例变量=对象的变量
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		//属性的初始化应该使用: 构造器，构造方法
		//  构造器 后续章节讲解
		e1.name = "tom";  e1.age = 10;
		e1.gender = '男'; e1.salary = 1000; 
		e2.name = "Jerry"; e2.age = 20;
		e2.gender = '男'; e2.salary = 100;
		//输出员工信息
		print(e1);//利用对象将员工数据成组的传递 
		print(e2);//到方法中，简化的代码的书写！
	}
	public static void print(Emp e){
		System.out.println("姓名:"+e.name);
		System.out.println("年龄:"+e.age);
		System.out.println("性别:"+e.gender);
		System.out.println("薪水:"+e.salary);
	}

	public static void print(
			String name, int age, 
			char gender, double salary) {
		System.out.println("姓名:"+name);
		System.out.println("年龄:"+age);
		System.out.println("性别:"+gender);
		System.out.println("薪水:"+salary);
	}
}
/*
 * 根据数据的特点，按照每个员工特征，抽象为对应的模板
 * Emp 员工类
 */
class Emp{
	String name;
	int age;
	char gender;
	double salary;
}






