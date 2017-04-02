package cn.tedu.shooter;

import java.awt.image.BufferedImage;

public class Bee 
	extends FlyingObject
	implements Award{
	
	private int award;//�����������ʼ��

	public Bee(BufferedImage image) {
		this.image = image;
		width = image.getWidth();
		height = image.getHeight();
		x = (int)(Math.random()*
				(Sky.WIDTH-width));
		y = -height;
		award = (int)(Math.random()*3);
		int[] ary = {LEFT,RIGHT}; 
		//            0      1
		direction = 
				ary[(int)(Math.random()*2)];
	}
	
	/**
	 * �۷�ķ��з��� LEFT RIGHT
	 */
	private int direction;
	private static final int LEFT=-1;
	private static final int RIGHT=1;

	public int getAward() {
		return award;
	}
	public void move() {
		y++;
		if(x > Sky.WIDTH - width){
			direction = LEFT;
		}
		if(x<0){
			direction = RIGHT;
		}
		x+=direction;
	}
}
