package day11;
/*
 * 如何避免内存泄露: 对象使用结束以后，将引用赋值
 * 为null。
 */
public class Demo01 {
	public static void main(String[] args) {
		Cell c = new Cell(0,4);
		Cell[] cells = new Cell[10000000];
		for(int i=0; i<10000000; i++){
			c = new Cell(0,5);
			//将对象引用保存到数组中不释放
			//会引起内存泄露！
			cells[i]=c;
			c= null;
		}
		System.out.println("OK");
	}
}
class Cell{
	int row;
	int col;
	int x;
	int y;
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public void test(){
		int n = 5;
	}
}
