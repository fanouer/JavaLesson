package day11.pm.sub;

import day11.pm.Point;

public class Demo08 {

	public static void main(String[] args) {
		Point p = new Point(3,4);
		/*
		 * p.t 是默认的访问修饰词，仅仅在包内部
		 * 有效，在包外就不开见了！
		 */
		//System.out.println(p.t);
		System.out.println(p.z); 
	}

}
