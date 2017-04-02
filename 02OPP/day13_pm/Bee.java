package day13;
/**
 * 小蜜蜂
 */
public class Bee 
	extends FlyingObject
	implements Award{
	/*
	 * 蜜蜂的飞行方向
	 */
	private int direction;
	private static final int RIGHT = 1;
	private static final int LEFT = -1;
	
	public Bee(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		long now = System.currentTimeMillis();
		if(now%2==0){
			direction = RIGHT;
		}else{
			direction = LEFT;
		}
	}
	public void move() {
		y++;
		if(x>480-w){
			direction = LEFT;
		}
		if(x<0){
			direction = RIGHT;
		}
		x+=direction;
	}
	
	public int getAward() {
		return 100;
	}
}
