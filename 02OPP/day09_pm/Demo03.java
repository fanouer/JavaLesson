package day09;

public class Demo03 {
	public static void main(String[] args) {
		//Cell c1 = new Cell();
		//c1.row = 0;
		//c1.col = 4;
		Cell c1 = new Cell(0, 4);
		//�������ص����䷽��
		c1.drop();//����1��
		c1.drop(5);//����5��
		System.out.println(c1.row); //6
		
		Cell c2 = new Cell(0, 3);
	}
}
class Cell{
	int row;
	int col;
	/*
	 * �����������ڳ�ʼ��һ�����Ӷ��󣨳�ʼ�����ԣ���
	 */
	public Cell(int r, int c){
		this.row = r;
		col = c;
	}
	
	public void drop() { 
		int row;//�ֲ�����
		this.row++;
	}
	/*
	 * ���ص����䷽����
	 * ʵ������n�����㷨
	 */
	public void drop(int steps){
		row+=steps;
	}
}



