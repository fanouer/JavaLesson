package cn.tedu.shooter;
/**
 * 定义了敌人接口，任何被击中可以得分的对象都需要
 * 实现这个接口
 */
public interface Enemy {
	/**
	 * 击中以后，获取打掉敌人的得分
	 */
	int getScore();
}
