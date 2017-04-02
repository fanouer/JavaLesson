package day13;

/*
 * 向上造型语法
 */
public class Demo03 {

	public static void main(String[] args) {
		Bullet bullet = 
				new Bullet(1, 1, 0, 0);
		//向上造型:只能造型为父类型(类、接口)
		FlyingObject obj = bullet;
		//没有实现接口,没有继承关系不能造型
		//Award awd = bullet;
		//Bee b = bullet;
		//
		//注意：Java编译器根据类型检查调用方法是否匹配
		// 没有的方法不允许调用！
		Award awd = new Nokia();
		//awd 的类型 Award 有 getAward 方法
		int a = awd.getAward();
		// awd 没有getScore() 方法就不能
		// 调用！
		//int s = awd.getScreo();//编译错误 
		
	}
}








