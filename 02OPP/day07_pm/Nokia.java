package day13;
/*
 * 一个类可以继承一个父类，实现多个接口
 * 实现 （implements）
 * 表示：Nokia 是一种飞行物，同时也是一种奖品
 * 在语法上：继承FlyingObject 公共属性和方法
 *   也要实现全部父类型的 抽象方法。
 */
public class Nokia 
	extends FlyingObject
	implements Award, Enemy{
	
	public void move() {
		y++;
	}
	public int getAward() {
		return GIRL;
	}
	public int getScore() {
		return 100;
	}
}







