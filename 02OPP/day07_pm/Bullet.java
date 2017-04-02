package day13;

public class Bullet 
	extends  FlyingObject{

	public Bullet(int x,int y,int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public void move() {
		y--;
	}
}
