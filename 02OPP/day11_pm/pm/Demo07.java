package day11.pm;

public class Demo07 {
	public static void main(String[] args) {
		/*
		 * 在同一个包(package)中可以直接使用
		 * 同包的其他类
		 */
		Point p = new Point(3, 4);
		/*
		 * 私有属性不能访问
		 */
		//System.out.println(p.x); 
		p.test();
		/*
		 * 公有属性可以进行任意的读写
		 */
		System.out.println(p.z);
		p.z = 100;
		System.out.println(p.z); 
		/*
		 * Demo07 和 Point 都在同一个包中 day11.pm
		 * Demo07 可以访问Point的t属性
		 */
		System.out.println(p.t); 
	}
}





