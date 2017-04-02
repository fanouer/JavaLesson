package cn.tedu.shooter;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 小飞机既是飞行物也是敌人 
 */
public class Airplane 
	extends FlyingObject
	implements Enemy{
	
	/**
	 * 飞行速度，利用构造器初始化为 1~3随机数
	 */
	private double speed; 
	
	public Airplane(BufferedImage image) {
		this.image = image;
		
		this.height = image.getHeight();
		this.width = image.getWidth();
		//飞机初始位置：在屏幕上方的某个随机位置。
		Random random = new Random();
		this.x = random.nextInt(
				Sky.WIDTH-width);
		this.y = -height;
		this.speed = Math.random()*3+1;
	}
	
	public int getScore() {
		return 1;
	}
	public void move() {
		y+=speed;
	}
}
