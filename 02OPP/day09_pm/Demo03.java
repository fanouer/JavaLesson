package day09;

public class Demo03 {
	public static void main(String[] args) {
		//Cell c1 = new Cell();
		//c1.row = 0;
		//c1.col = 4;
		Cell c1 = new Cell(0, 4);
		//调用重载的下落方法
		c1.drop();//下落1步
		c1.drop(5);//下落5步
		System.out.println(c1.row); //6
		
		Cell c2 = new Cell(0, 3);
	}
}
class Cell{
	int row;
	int col;
	/*
	 * 构造器：用于初始化一个格子对象（初始化属性）！
	 */
	public Cell(int r, int c){
		this.row = r;
		col = c;
	}
	
	public void drop() { 
		int row;//局部变量
		this.row++;
	}
	/*
	 * 重载的下落方法：
	 * 实现下落n步的算法
	 */
	public void drop(int steps){
		row+=steps;
	}
}



