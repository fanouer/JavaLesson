package day04;
/**
 * 泛型，JDK5.0以后推出的新特性
 * 泛型也成为参数化类型，当使用者使用当前类时，将泛型
 * 的实际类型传入。
 * 泛型可以规定当前类的属性类型，方法参数的类型，
 * 以及方法返回值类型
 * @author Administrator
 *
 * @param <T>
 */
public class Point<T> {
	private T x;
	private T y;	
	public Point(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
}







