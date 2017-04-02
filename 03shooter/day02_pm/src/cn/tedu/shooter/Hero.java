package cn.tedu.shooter;

import java.awt.image.BufferedImage;

public class Hero 
	extends FlyingObject{
	
	public Hero(BufferedImage image) {
		this.image = image;
		width = image.getWidth();
		height = image.getHeight();
		y = 400;
		//��Ӣ�۾��м���
		x = (Sky.WIDTH-width)/2;
	}
	
	/**
	 * ��Ӣ�۷ɻ��ƶ�������λ����
	 * x,y ��ʾ��ǰ����λ��
	 */
	public void move(int x, int y){
		x -= width/2;
		y -= height/2;
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		//������ƶ�
	}
}
