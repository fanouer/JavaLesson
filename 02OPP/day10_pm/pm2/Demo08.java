package day10.pm2;

public class Demo08 {

	public static void main(String[] args) {
		T t = new T();
		t.drop();
		System.out.println(t.cells[0].row);
	}
}
/*
 * extends 表示继承关系
 * 子类型 extends 父类型
 * 表示子类型继承于父类型，子类就从父类中继承了属性
 * 和方法，子类无需再次定义，父类中的属性和方法
 */
class T extends Tetromino {
	public T() {
		cells[0] = new Cell(0,4);
		cells[1] = new Cell(0,3);
		cells[2] = new Cell(0,5);
		cells[3] = new Cell(1,4);
	}
}
class J extends Tetromino{
	public J() {
		cells[0] = new Cell(0,4);
		cells[1] = new Cell(0,3);
		cells[2] = new Cell(0,5);
		cells[3] = new Cell(1,5);
	}
}
class L extends Tetromino{
	
}
/*
 * 4格拼版方块
 * 是7种方块的父类型
 * 封装了 7 种方块的公共属性和公共方法
 */
class Tetromino{
	Cell[] cells = new Cell[4];
	public void drop(){
		for(int i=0; i<4; i++){
			cells[i].row++;
		}
	}
}

class Cell{
	int row;
	int col;
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
}