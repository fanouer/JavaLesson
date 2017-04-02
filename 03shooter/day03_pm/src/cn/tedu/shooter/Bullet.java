package cn.tedu.shooter;

import java.awt.image.BufferedImage;

/**
 * 子弹类型
 */
public class Bullet
	extends FlyingObject{
	
	public Bullet(int x, int y,
			BufferedImage image){
		this.x = x;
		this.y = y;
		this.image = image;
		width = image.getWidth();
		height = image.getHeight();
	}
	
	/**
	 * 子弹从下向上飞行，速度很快
	 */
	public void move() {
		y-=15;
	}
	/**
	 * 在子弹中重写 出界检查方法，检查当前子弹是否
	 * 飞出上边界
	 */
	public boolean outOfBounds() {
		return y <= -height;
	}
}




