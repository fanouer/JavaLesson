package day10;

public class Demo03 {
	public static void main(String[] args) {
		/*
		 * ���������������飬��ʾ4�񷽿�
		 */
		//�����������
		Cell[] t = new Cell[4];
		//���������ÿ��Ԫ�أ�����
		t[0]=new Cell(0,3);
		t[1]=new Cell(0,4);
		t[2]=new Cell(0,5);
		t[3]=new Cell(1,4);
		//����L�ͷ���
		Cell[] l = new Cell[]{
			new Cell(0,3), new Cell(0,4),
			new Cell(0,5), new Cell(1,3)
		};
		//��ʼ���������飬�����ַ�ʽ
		// 1 ���������飬����һ��ʼ��ÿ��Ԫ��
		// 2 �������飬ͬʱ��ʼ��ÿ��Ԫ��
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


