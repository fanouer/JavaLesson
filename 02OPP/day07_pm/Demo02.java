package day07;

public class Demo02 {
	public static void main(String[] args) {
		Cell c1 = new Cell();//������һ��2������
		c1.row = 5;
		c1.col = 3;
		Cell c2 = new Cell();//������һ��2������
		c2.row = 6;
		c2.col = 7;
		System.out.println(c2.row);
		
		Cell c3 = c1;
		System.out.println(c3.row);//5
		c3 = null;
		System.out.println(c3.row);
		//���ϴ�������
		//A.�������  B.�����쳣 C.0 D.null
	}
}
/*
 * ���� ���� ����
 */
class Cell{
	int row;
	int col;
}








