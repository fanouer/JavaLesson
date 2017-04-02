package cn.tedu.shooter;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * С�ɻ����Ƿ�����Ҳ�ǵ��� 
 */
public class Airplane 
	extends FlyingObject
	implements Enemy{
	
	/**
	 * �����ٶȣ����ù�������ʼ��Ϊ 1~3�����
	 */
	private double speed; 
	
	public Airplane(BufferedImage image) {
		this.image = image;
		
		this.height = image.getHeight();
		this.width = image.getWidth();
		//�ɻ���ʼλ�ã�����Ļ�Ϸ���ĳ�����λ�á�
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
