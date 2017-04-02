package cn.tedu.shooter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sky 
	extends FlyingObject{
	
	public static final int WIDTH = 480;
	public static final int HEIGHT = 852;
	
	private int y1;
	private int y2;
	
	public Sky(BufferedImage image) {
		//初始化 天空的背景图片
		//World 类静态读取图片文件.png到图片对象
		//利用构造器参数传递当前的属性
		this.image = image;
		//this.y = 0;
		this.y1=-image.getHeight();
		this.y2=0;
		this.x = 0;
	}
	
	public void move() {
		//y++;
		y1++;
		y2++;
		if(y2>=image.getHeight()){
			y2 = -image.getHeight();
		}
		if(y1>=image.getHeight()){
			y1 = -image.getHeight();
		}
	}
	/**
	 * 利用画笔g将当前的天空对象绘制出来 
	 */
	public void paint(Graphics g){
		g.drawImage(image, (int)x, y1, null);
		g.drawImage(image, (int)x, y2, null);
	}
}





