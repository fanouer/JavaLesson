package cn.tedu.shooter;

import java.awt.image.BufferedImage;

/**
 * �ӵ�����
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
	 * �ӵ��������Ϸ��У��ٶȺܿ�
	 */
	public void move() {
		y-=15;
	}
	/**
	 * ���ӵ�����д �����鷽������鵱ǰ�ӵ��Ƿ�
	 * �ɳ��ϱ߽�
	 */
	public boolean outOfBounds() {
		return y <= -height;
	}
}




