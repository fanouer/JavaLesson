package day07.pm;

public class Demo05 {
	public static void main(String[] args) {
		//��ʾ J �ͷ���
		Cell c1 = new Cell();//{0,0}
		Cell c2 = new Cell();//{0,0}
		Cell c3 = new Cell();//{0,0}
		Cell c4 = new Cell();//{0,0}
		//�������ݽ��г�ʼ��
		//J{5,3}{5,4}{5,5}{6,5}
		c1.row=5;
		c1.col=3;
		c2.row=5;
		c2.col=4;
		c3.row=5;
		c3.col=5;
		c4.row=6;
		c4.col=5;
		print(c1, c2, c3, c4); 
		c1.row++;
		c2.row++;
		c3.row++;
		c4.row++;
		System.out.println("�����Ժ�"); 
		print(c1, c2, c3, c4); 
		
		c1.row++;
		c2.row++;
		c3.row++;
		c4.row++;
		System.out.println("�����Ժ�"); 
		print(c1, c2, c3, c4); 
		
	}
	
	static void print(Cell c1, Cell c2,
			Cell c3, Cell c4){
		for(int row=0; row<20; row++){
			for(int col=0;col<10; col++){
				if((row==c1.row&&col==c1.col)
				  ||(row==c2.row&&col==c2.col)
				  ||(row==c3.row&&col==c3.col)
				  ||(row==c4.row&&col==c4.col)){
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
	
}
/*
 * ������һ���ࣺ
 * ҵ����� -> �������� -> �����ݳ���Ϊ��
 * ˼�����̳�Ϊ�������:���ݶ�����ص���������ࡱ(����)
 */
class Cell{
	int row;
	int col;
}



