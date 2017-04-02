package cn.tedu.shooter;

import java.awt.image.BufferedImage;

public class Hero 
	extends FlyingObject{
	
	/**
	 * 得分
	 */
	private int score;
	
	private boolean doubleFire;
	
	public Hero(BufferedImage image) {
		this.image = image;
		width = image.getWidth();
		height = image.getHeight();
		y = 400;
		//将英雄居中计算
		x = (Sky.WIDTH-width)/2;
		
		life = 3;
		score = 0;
		doubleFire = false;
	}
	public boolean isDoubleFire() {
		return doubleFire;
	}
	public void setDoubleFire(boolean b){
		this.doubleFire = b;
	}
	public void addLife(int life){
		this.life += life;
	}
	public int getScore(){
		return score;
	}
	public void add(int score){
		this.score += score;
	}
	
	/**
	 * 将英雄飞机移动到鼠标的位置上
	 * x,y 表示当前鼠标的位置
	 */
	public void move(int x, int y){
		x -= width/2;
		y -= height/2;
		this.x = x;
		this.y = y;
		
		
	}
	
	public void move() {
		//随鼠标移动
	}
}
