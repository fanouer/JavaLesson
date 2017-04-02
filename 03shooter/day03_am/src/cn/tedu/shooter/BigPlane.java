package cn.tedu.shooter;

import java.awt.image.BufferedImage;

/** 大飞机类型，是敌人也是奖品 */
public class BigPlane
	extends FlyingObject
	implements Enemy, Award{
	
	private int award;//利用构造器初始化
	
	public BigPlane(BufferedImage image) {
		this.image = image;
		width = image.getWidth();
		height = image.getHeight();
		x = (int)(Math.random()*
				(Sky.WIDTH-width));
		y = -height;
		award = (int)(Math.random()*3);
	}
	
	public int getAward() {
		return award;
	}
	public int getScore() {
		return 5;
	}
	public void move() {
		y+=3;
	}
}
