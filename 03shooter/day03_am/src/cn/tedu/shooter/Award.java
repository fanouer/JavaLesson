package cn.tedu.shooter;

/**
 * 奖励接口，任何的打掉以后，可以获取奖品的对象
 * 需要实现这个接口 
 */
public interface Award {
	/** 
	 * 奖励类型：从0开始声明： 0 1 2
	 * 便于使用随机算法参数奖品 
	 */
	int DOUBLE_FIRE = 0;
	int LIFE = 1;
	int DOUBLE_LIFE = 2;
	/**
	 * 击中以后，获取相应的奖品，奖励值来自
	 * DOUBLE_FIRE 双倍火力
	 * LIFE        一条命
	 * DOUBLE_LIFE 两条命
	 */
	int getAward();
}



