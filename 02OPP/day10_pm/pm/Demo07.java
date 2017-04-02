package day10.pm;

public class Demo07 {
	public static void main(String[] args) {
		//创建 T 型方块对象
		T t = new T();
		//执行下落功能
		t.drop();
		//检查测试软件运行下落以后的情况：
		System.out.println(t.cells[0].row);
	}
}

class J{
	Cell[] cells = new Cell[4];
	public J() {
		cells[0]=new Cell(0,4);
		cells[1]=new Cell(0,3);
		cells[2]=new Cell(0,5);
		cells[3]=new Cell(1,5);
	}
	public void drop(){
		for(int i=0; i<4; i++){
			cells[i].row++;
		}
	}
}
class T{
	Cell[] cells = new Cell[4];
	public T() {
		cells[0]=new Cell(0,4);
		cells[1]=new Cell(0,3);
		cells[2]=new Cell(0,5);
		cells[3]=new Cell(1,4);
	}
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
 