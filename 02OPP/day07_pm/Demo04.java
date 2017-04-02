package day13;

public class Demo04 {

	public static void main(String[] args) {
		/*
		 * 强制转型
		 */
		Award awd = new Nokia();
		int a = awd.getAward();
		// 如果需要调用 getScore();
		// awd.getScore();
		Enemy e = (Enemy) awd;
		int n = e.getScore();
		//如果需要调用 move 方法，需要转型为
		// FlyingObject 
		FlyingObject o = (FlyingObject) awd;
		o.move();
		
		// 强制转型是有风险的：使用需谨慎！
		// 如下代码 没有问题
		o = new Nokia();
		o.move();
		//o引用的对象确实是Award的子类型，转换成功
		Award ax = (Award) o;
		ax.getAward();
		//如下代码出现运行异常
		o = new Bullet(1, 1, 1, 1);
		o.move();
		//o引用的对象不是Awaed子类，转换失败
		ax = (Award) o;//运行异常
		ax.getAward();
	}

}
