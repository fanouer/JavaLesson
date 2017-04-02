package cn.tedu.shooter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


/** 代表飞行物体 */
public abstract class FlyingObject {
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	
	protected int life = 1;
	/**
	 * 当前物体的显示图片，所有子类型都有各自的图片
	 */
	protected BufferedImage image;
	/**
	 * 减命
	 */
	public void subtractLife(){
		life--;
	}
	/** destory：销毁 */
	public void destory(){
		life=0;
	}
	/**
	 * 检查当前飞行物是否是活的 （life>0）
	 * @return true 表示还活着
	 */
	public boolean isActive(){
		return life>0;
	}
	
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
		double x1=this.x - other.width;
		double x2=this.x + this.width;
		double y1=this.y - other.height;
		double y2=this.y + this.height;
		//System.out.println(x1+","+x2);
		//System.out.println(y1+","+y2);
		//System.out.println(other.x+","+other.y);
		return x1<other.x && other.x<x2 &&
				y1<other.y && other.y<y2;
	}
	/**
	 * 所有的飞行物都有绘制方法：好处所有的飞行物
	 * 都有绘制方法：蜜蜂，飞机等
	 * 天空的绘制不同：“重写” 一下即可
	 */
	public void paint(Graphics g){
		g.drawImage(image, 
			(int)x, (int)y, null);
	}
	/** 
	 * FlyingObject 类中添加通用的出界检查方法
	 * 返回true 表示出界， 返回false表示没有出界
	 */
	public boolean outOfBounds(){
		return y >= Sky.HEIGHT;
//		if(y >= Sky.HEIGHT){
//			return true;
//		}else{
//			return false;
//		}
	}
}




