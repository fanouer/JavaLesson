package day10;

public class Demo03 {
	public static void main(String[] args) {
		/*
		 * 用于引用类型数组，表示4格方块
		 */
		//创建数组对象
		Cell[] t = new Cell[4];
		//创建数组的每个元素（对象）
		t[0]=new Cell(0,3);
		t[1]=new Cell(0,4);
		t[2]=new Cell(0,5);
		t[3]=new Cell(1,4);
		//创建L型方块
		Cell[] l = new Cell[]{
			new Cell(0,3), new Cell(0,4),
			new Cell(0,5), new Cell(1,3)
		};
		//初始化对象数组，有两种方式
		// 1 创建空数组，再逐一初始化每个元素
		// 2 创建数组，同时初始化每个元素
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


