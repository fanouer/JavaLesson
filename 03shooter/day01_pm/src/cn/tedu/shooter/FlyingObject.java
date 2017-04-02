package cn.tedu.shooter;

import java.awt.image.BufferedImage;


/** 代表飞行物体 */
public abstract class FlyingObject {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	/**
	 * 当前物体的显示图片，所有子类型都有各自的图片
	 */
	protected BufferedImage image;
	
	/*
	 * 移动方法：
	 * 声明了飞行物体是可以移动的！
	 */
	public abstract void move();
	
	/*
	 * 添加碰撞检查方法，子类自动继承这个方法
	 * 检查当前对象与另外一个飞行物对象是否发生
	 * 碰撞。数据来源：当前对象和参数（另外一个对象）
	 */
	public boolean duang(
			FlyingObject other){
		int x1=this.x - other.width;
		int x2=this.x + this.width;
		int y1=this.y - other.height;
		int y2=this.y + this.height;
		return x1<other.x && other.x<x2 &&
				y1<other.y && other.y<y2;
	}
}




