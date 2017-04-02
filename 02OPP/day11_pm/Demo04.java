package day11;

public class Demo04 {
	public static void main(String[] args) {
		Airplane a = new Airplane();
		Bee bee = new Bee();
		
		//飞机向下行走
		a.move();
		System.out.println(a.x+","+a.y);
		//蜜蜂斜向行走
		bee.move();
		System.out.println(bee.x+","+bee.y);
		//测试蜜蜂飞行一会是否发生了反弹现象
		for(int i=0; i<500; i++){
			bee.move();
		}
		System.out.println(bee.x+","+bee.y);
		
		//使用父类型定义的变量，可以引用子类型的
		//实例(子类型对象) 
		FlyingObject obj = new Bee();
		// 使用父类型变量调用重写的方法时候，执行
		// 的方法，是子类重写的方法！父类的方法被
		// 覆盖（屏蔽）了！
		obj.move();
		System.out.println(obj.x+","+obj.y);
	}
}
/*
 * 代表飞行的物体
 */
class FlyingObject{
	int x;
	int y; 
	int w;
	int h;
	public void move(){
		y++;
	}
}
class Airplane extends FlyingObject{
	//构造器
}
class BigPlane extends FlyingObject{

}
class Bee extends FlyingObject{
	int direction;//蜜蜂的飞行方向
	public Bee() {
		direction = 1;
		w = 40;
	}
	/*
	 * 在子类中重写父类的方法，修改父类的行为
	 * 修改为斜向行走
	 */
	public void move() {
		//y++;
		/*
		 * 如果子类在重写父类方法，还需要用到
		 * 父类提供的算法，就可以使用super.move()
		 * 进行调用，达到重用算法的目的。
		 */
		super.move();
		if(x > 480 - w){
			direction = -1;
		}
		if(x<0){
			direction = 1;
		}
		x+=direction;
	}
}

















