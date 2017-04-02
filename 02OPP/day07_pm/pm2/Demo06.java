package day07.pm2;

public class Demo06 {
	public static void main(String[] args) {
		/*
		 * new J() 实际上是调用的构造器 
		 * new J() 运算就是重用对象属性初始化过程
		 * 构造器可以简化对象属性的初始化
		 */
		J j = new J();
		print(j);
		j.drop();
		j.drop();
		j.drop();
		System.out.println("下落3步");
		print(j);

	}
	static void print(J j){
		for(int row=0; row<20; row++){
			for(int col=0; col<10; col++){
				if((row==j.c1.row&&col==j.c1.col)
				  ||(row==j.c2.row&&col==j.c2.col)
				  ||(row==j.c3.row&&col==j.c3.col)
				  ||(row==j.c4.row&&col==j.c4.col)){
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}
class Cell{
	int row;//基本类型属性默认值是0
	int col;
}
class J{
	Cell c1;//引用类型属性默认值是null
	Cell c2;
	Cell c3;
	Cell c4;	
	/*
	 * 构造器（构造方法）：主要用于初始化对象的属性
	 * 对j型方块的4个属性进行赋值（初始化）
	 * 语法: 和类名一样的方法，不能定义返回值
	 */
	public J(){
		//将对象的属性进行赋值
		c1 = new Cell();
		c1.row = 5;
		c1.col = 3;
		c2 = new Cell();
		c2.row = 5;
		c2.col = 4;
		c3 = new Cell();
		c3.row = 5;
		c3.col = 5;
		c4 = new Cell();
		c4.row = 6;
		c4.col = 5;
	}
	/*
	 * 对象的方法
	 *   1 是对象的行为（功能）
	 *     当前方法表示 当前对象的下落(drop)功能
	 *   2 是对象的属性相关的计算过程（算法）
	 *     下落功能算法：每个格子的行++
	 *   3 对象的方法不要使用 static 关键字！
	 *   4 任何时候需要下落功能，只需要调用方法
	 *     就可以“重用”下落算法！
	 */
	public void drop(){
		c1.row++;
		c2.row++;
		c3.row++;
		c4.row++;
	}
}



