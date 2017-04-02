package day13;

public class Airplane 
	extends FlyingObject
	implements Enemy{
	
	public Airplane(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public int getScore() {
		return 10;
	}
	
	public void move() {
		y++;
	}
}
