package cn.tedu.shooter;

import java.awt.image.BufferedImage;

public class Sky 
	extends FlyingObject{
	
	public static final int WIDTH = 480;
	public static final int HEIGHT = 852;
	
	public Sky(BufferedImage image) {
		//初始化 天空的背景图片
		//World 类静态读取图片文件.png到图片对象
		//利用构造器参数传递当前的属性
		this.image = image;
	}
	
	public void move() {
		
	}
	
}
