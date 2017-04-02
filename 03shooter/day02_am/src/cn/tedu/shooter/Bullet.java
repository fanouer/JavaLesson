package cn.tedu.shooter;

/**
 * 子弹类型
 */
public class Bullet
	extends FlyingObject{
	
	/**
	 * 子弹从下向上飞行，速度很快
	 */
	public void move() {
		y-=3;
	}
}
