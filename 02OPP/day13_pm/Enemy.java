package day13;
/*
 * 敌人接口，凡是被击中可以获取分数的对象，都要
 * 实现敌人接口
 * 利用接口 可以约定凡是敌人都可以获取分数
 */
public interface Enemy {
	/*
	 * 击中以后，可以调用getScreo方法获取分数
	 */
	int getScore();
}
