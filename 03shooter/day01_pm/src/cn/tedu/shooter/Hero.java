package cn.tedu.shooter;

public class Hero 
	extends FlyingObject{
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
