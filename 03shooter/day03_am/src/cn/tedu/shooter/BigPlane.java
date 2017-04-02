package cn.tedu.shooter;

import java.awt.image.BufferedImage;

/** ��ɻ����ͣ��ǵ���Ҳ�ǽ�Ʒ */
public class BigPlane
	extends FlyingObject
	implements Enemy, Award{
	
	private int award;//���ù�������ʼ��
	
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
