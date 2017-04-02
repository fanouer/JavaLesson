package cn.tedu.shooter;

import java.awt.image.BufferedImage;

public class Hero 
	extends FlyingObject{
	
	public Hero(BufferedImage image) {
		this.image = image;
	}
	
	/**
	 * 将英雄飞机移动到鼠标的位置上
	 * x,y 表示当前鼠标的位置
	 */
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void move() {
		//随鼠标移动
	}
}
