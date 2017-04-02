package day11.pm;

public class Point {
	/*
	 * 私有属性，仅仅在类内部可以看见
	 * x 和 y 被封装到类的内部了
	 */
	private int x;
	private int y;
	public int z;
	/*
	 * 默认的访问范围：当前包内有效！day11.pm
	 */
	int t;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		z = 6;
		t = 100;
	}
	public void test(){
		System.out.println(x+","+y); 
	}
}
