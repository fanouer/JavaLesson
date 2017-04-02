package day10.pm2;

public class Demo08 {

	public static void main(String[] args) {
		T t = new T();
		t.drop();
		System.out.println(t.cells[0].row);
	}
}
/*
 * extends ��ʾ�̳й�ϵ
 * ������ extends ������
 * ��ʾ�����ͼ̳��ڸ����ͣ�����ʹӸ����м̳�������
 * �ͷ��������������ٴζ��壬�����е����Ժͷ���
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
 * 4��ƴ�淽��
 * ��7�ַ���ĸ�����
 * ��װ�� 7 �ַ���Ĺ������Ժ͹�������
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