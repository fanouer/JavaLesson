package day08;

import java.util.Scanner;

public class Demo02 {
	public static void main(String[] args) {
		T t = new T();
		Scanner in = new Scanner(System.in);
		while(true){
			//显示T型方块
			print(t);
			//等待用户输入
			String s = in.nextLine();
			//检查 如果是 s 就执行 t.drop()
			if(s.equals("s")){
				t.drop();
			}else if(s.equals("d")){
				t.moveRight();
			}else if(s.equals("a")){
				t.moveLeft();
			}
		}
	}
	
	public static void print(T t){
		for(int row=0; row<20; row++){
			for(int col=0; col<10; col++){
				if((t.c1.row==row&&t.c1.col==col)
				||(t.c2.row==row&&t.c2.col==col)
				||(t.c3.row==row&&t.c3.col==col)
				||(t.c4.row==row&&t.c4.col==col)){
					System.out.print("*");
				}else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}
class Cell{
	int row;
	int col;
	public Cell(int r, int c) {
		row = r;
		col = c;
	}
}
class T{
	Cell c1;
	Cell c2;
	Cell c3;
	Cell c4;
	public T() {
		c1 = new Cell(0,3);
		c2 = new Cell(0,4);
		c3 = new Cell(0,5);
		c4 = new Cell(1,4);
	}
	/*
	 * 为T类型增加方法(功能)，下，左右移动功能
	 */
	public void drop(){
		c1.row++;
		c2.row++;
		c3.row++;
		c4.row++;
	}
	public void moveLeft(){
		c1.col--;
		c2.col--;
		c3.col--;
		c4.col--;
	}
	public void moveRight(){
		c1.col++;
		c2.col++;
		c3.col++;
		c4.col++;
	}
}








