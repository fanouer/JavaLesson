package cn.tedu.shooter;

public class Bee 
	extends FlyingObject
	implements Award{
	
	private int award;//�����������ʼ��
	/**
	 * �۷�ķ��з��� LEFT RIGHT
	 */
	private int direction;
	private static final int LEFT=-1;
	private static final int RIGHT=1;

	public int getAward() {
		return award;
	}
	public void move() {
		y++;
		if(x > Sky.WIDTH - width){
			direction = LEFT;
		}
		if(x<0){
			direction = RIGHT;
		}
		x+=direction;
	}
}
