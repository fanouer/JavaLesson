package day14;

public class Demo02 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.test();
		
	}
}
class Outer{
	int time=2;
	/*
	 * 添加测试方法：
	 * 内部类一般是在外部类的内部使用！（封装现象）
	 */
	public void test(){
		//在Outer的内部添加测试方法，测试内部类Inner
		Inner obj = new Inner();
		obj.timeInc();
	}
	
	/*
	 * 定义在类的内部的类，称为内部类
	 * 封装：Inner在Outer的内部，一般在内部使用
	 * 共享：Inner可以共享内部类的数据
	 *   为了区别内部类和外部类的数据，可以不省略
	 *    外部类.this.变量
	 */
	class Inner{
		int time=4;
		public void timeInc(){
			/*
			 * 内部类共享外部类数据的通道
			 *  Outer.this 隐含引用当前外部类的对象
			 *  一般可以省略（变量名冲突时候不能省略！）
			 */
			
			//day14.Outer.this.time是变量的全名
			day14.Outer.this.time++;
			day14.Outer.Inner.this.time++;
			System.out.println(Outer.this.time);
			System.out.println(this.time);
		}
	}
}







