package day12;

public class Demo11 {
	public static void main(String[] args) {
		/*
		 * 编译器不允许创建抽象类的实例！
		 */
		//Shape s = new Shape();
		/*
		 * 抽象类可以声明变量，引用具体类型的对象
		 */
		Circle c = new Circle(10);
		Square s = new Square(10);
		System.out.println(c.area());
		System.out.println(s.area());
		
		Shape ss = c;
		ss = s;
		//多态现象
		
		
		
	}
}
/*
 * 正方形
 */
class Square extends Shape{
	public Square(double c) {
		this.c = c;
	}
	public double area(){
		double d = c/4;
		return d*d;
	}
}
/*
 * 从抽象类继承具体子类。
 * 具体子类必须实现（重写）抽象类中的抽象方法！
 */
class Circle extends Shape{
	public Circle(double c) {
		this.c = c;//初始化圆的周长
	}
	/*
	 * 重写父类中的抽象方法
	 */
	public double area(){
		double r = c/3.1415926535897932/2;
		return Math.PI * r * r;
	}
}
/*
 * 代表抽象的图形
 * abstract 关键字可以限制，创建对象。
 * 可以避免创建不完整对象的实例，避免影响软件的可靠性
 * 抽象类用于作为继承根类，被其他类继承，共享
 * 公共属性和方法的！
 */
abstract class Shape{
	/*
	 * 表示图形的周长
	 */
	protected double c;
	/*
	 * 计算图形面积的方法
	 * 子类中一定的方法，但是无法确定算法的方法
	 * 可以定义为抽象方法!
	 */
	public abstract double area();
}







