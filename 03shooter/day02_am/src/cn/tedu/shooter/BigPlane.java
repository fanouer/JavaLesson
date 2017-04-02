package cn.tedu.shooter;
/** 大飞机类型，是敌人也是奖品 */
public class BigPlane
	extends FlyingObject
	implements Enemy, Award{
	
	private int award;//利用构造器初始化
	
	public int getAward() {
		return award;
	}
	public int getScore() {
		return 5;
	}
	public void move() {
		y+=2;
	}
}
