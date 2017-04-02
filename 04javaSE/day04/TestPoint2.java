package day04;
/**
 * 泛型的实际类型是Object
 * 我们在向泛型赋值时，编译器会
 * 检查类型，当我们获取一个泛型的值
 * 时，也会自动类型转换。
 * @author Administrator
 *
 */
public class TestPoint2 {
	public static void main(String[] args) {
		Point<Integer> p1
			= new Point<Integer>(1,2);
		//编译器会检查实际值是否符合泛型要求
		p1.setX(2);
		//获取值时会自动造型
		int x = p1.getX();
		System.out.println("x:"+x);
		//若不指定，则为原型Object
		Point p2 = p1;
		
		p2.setX("二");
		System.out.println(p2.getX());
		//类造型异常!
		x = p1.getX();
		System.out.println("x:"+x);
		
	}
}






