package day12;
/*
 * Java 源文件语法规定：
 *   1 一个java文件中只能有一个公有类！ 
 *     其他类必须是默认修饰类（同包类）
 *   2 文件名必须和公有类名一致
 *   3 如果没有公有类，文件名和任意类名一致
 *   4 默认修饰类（同包类）的可访问范围，是当前包
 *     内部有效！
 *   5 为了避免默认类只能在当前包中使用，无法跨包
 *   访问！约定：一个java文件一个公有类！
 *
 * day12
 *   |--Demo01.java
 *       |-- public class Demo01
 *       |-- class Point
 * day12.am
 *   |-- Demo02{
 *         main(){
 *           Point 不能访问
 *           Demo01 可以访问
 *         }
 *       }
 *          
 *   
 *  
 *
 */

public class Demo01 {
	public static void main(String[] args) {
		Point p = new Point(5,0);
		//System.out.println(p.x);//编译错
		/*
		 * 可以利用方法获取对象的属性
		 * 属性是只读的！可以控制属性的读写
		 */
		System.out.println(p.getX()); //5
		p.setX(6);
		System.out.println(p.getX()); //6
	}
}
class Point{
	private int x;
	private int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	/* 属性访问方法，getX 用于读取属性
	 * setX 用于修改属性 */
	//public int getX(){
		//加入处理逻辑
	//	return x;
	//}
	/*
	 * setX方法用于修改属性，不需要返回值
	 * 参数代表被修改的值
	 */
	//public void setX(int x){
		//加入处理逻辑
	//	this.x = x;
		//加入处理逻辑
	//}
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
}

