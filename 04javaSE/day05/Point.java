package day05;
/**
 * 该类用于测试作为集合元素进行排序使用
 * @author Administrator
 *
 */
public class Point implements Comparable<Point>{
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "("+x+","+y+")";
	}
	
	/**
	 * 该方法是定义比较大小的规则，是判断当前对象
	 * 与给定的参数对象比较。
	 * 返回值不关心具体值，只关注取值范围:
	 * 当返回值>0:当前对象比参数对象大
	 * 当返回值<0:当前对象比参数对象小
	 * 当返回值=0:两个对象相等 
	 * 
	 */
	public int compareTo(Point o) {
		int len = this.x*this.x+this.y*this.y;
		int olen = o.x*o.x+o.y*o.y;
		return len-olen;
	}
	
	
}





