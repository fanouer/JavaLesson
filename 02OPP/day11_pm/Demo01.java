package day11;
/*
 * ��α����ڴ�й¶: ����ʹ�ý����Ժ󣬽����ø�ֵ
 * Ϊnull��
 */
public class Demo01 {
	public static void main(String[] args) {
		Cell c = new Cell(0,4);
		Cell[] cells = new Cell[10000000];
		for(int i=0; i<10000000; i++){
			c = new Cell(0,5);
			//���������ñ��浽�����в��ͷ�
			//�������ڴ�й¶��
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
