package day02;
/**
 * 该类用于测试Object相关方法的重写
 * @author Administrator
 */
public class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	/**
	 * 当我们需要使用一个类的equals方法比较两个
	 * 对象内容是否一致("像不像")时，就应当重写
	 * 该方法。JAVA API提供的类基本上都重写过了。
	 */
	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		if(o == this){
			return true;
		}
		if(o instanceof Point){
			Point p = (Point)o;
			return this.x==p.x&&this.y==p.y;
		}		
		
		return false;
	}
}








