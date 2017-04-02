package day13;
/**
 * 奖品接口
 * 任何提供奖品的类型，都实现这个奖品接口
 */
public interface Award {
	/*
	 * 接口中只能定义常量和抽象方法
	 * 可以省略 public static final 
	 */
	int LIFE100 = 1;//100条命
	int FIRE10 = 3;//10倍火力
	int GIRL = 4;//颜如玉
	/*
	 * 获取奖品的方法
	 * 抽象方法，省略public abstract
	 */
	int getAward();
}



