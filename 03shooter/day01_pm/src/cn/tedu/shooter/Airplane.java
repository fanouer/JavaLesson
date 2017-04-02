package cn.tedu.shooter;
/**
 * 小飞机既是飞行物也是敌人 
 */
public class Airplane 
	extends FlyingObject
	implements Enemy{
	/**
	 * 飞行速度，利用构造器初始化为 1~3随机数
	 */
	private int speed; 
	
	public int getScore() {
		return 1;
	}
	public void move() {
		y+=speed;
	}
}
