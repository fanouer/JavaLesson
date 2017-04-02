package cn.tedu.shooter;

import java.awt.image.BufferedImage;

public class Hero 
	extends FlyingObject{
	
	/**
	 * �÷�
	 */
	private int score;
	
	private boolean doubleFire;
	
	public Hero(BufferedImage image) {
		this.image = image;
		width = image.getWidth();
		height = image.getHeight();
		y = 400;
		//��Ӣ�۾��м���
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
