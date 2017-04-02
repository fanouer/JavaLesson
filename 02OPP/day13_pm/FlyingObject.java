package day13;
/**
 * 飞行物
 */
public abstract class FlyingObject {
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	
	/**
	 * 飞行物移动方法，子类必须实现（重写）
	 * 实现具体的飞行轨迹
	 */
	public abstract void move();
	/** 检查当前飞行物是否与另外一个发生了碰撞 */
	public boolean duang(FlyingObject other){
		int x1 = this.x - other.w;
		int x2 = this.x + this.w;
		int y1 = this.y - other.h;
		int y2 = this.y + this.h;
		System.out.println(
			"x1:"+x1+" x2:"+x2+
			" y1:"+y1+" y2:"+y2+
			" other.x:"+x+" other.y:"+other.y);
		//x1<other.x<x2 && y1<other.y<y2
		return x1<other.x && other.x<x2
			&& y1<other.y && other.y<y2;
	}
}










