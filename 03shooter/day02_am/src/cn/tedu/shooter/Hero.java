package cn.tedu.shooter;

import java.awt.image.BufferedImage;

public class Hero 
	extends FlyingObject{
	
	public Hero(BufferedImage image) {
		this.image = image;
	}
	
	/**
	 * ��Ӣ�۷ɻ��ƶ�������λ����
	 * x,y ��ʾ��ǰ����λ��
	 */
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void move() {
		//������ƶ�
	}
}
