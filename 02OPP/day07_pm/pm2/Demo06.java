package day07.pm2;

public class Demo06 {
	public static void main(String[] args) {
		/*
		 * new J() ʵ�����ǵ��õĹ����� 
		 * new J() ����������ö������Գ�ʼ������
		 * ���������Լ򻯶������Եĳ�ʼ��
		 */
		J j = new J();
		print(j);
		j.drop();
		j.drop();
		j.drop();
		System.out.println("����3��");
		print(j);

	}
	static void print(J j){
		for(int row=0; row<20; row++){
			for(int col=0; col<10; col++){
				if((row==j.c1.row&&col==j.c1.col)
				  ||(row==j.c2.row&&col==j.c2.col)
				  ||(row==j.c3.row&&col==j.c3.col)
				  ||(row==j.c4.row&&col==j.c4.col)){
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}
class Cell{
	int row;//������������Ĭ��ֵ��0
	int col;
}
class J{
	Cell c1;//������������Ĭ��ֵ��null
	Cell c2;
	Cell c3;
	Cell c4;	
	/*
	 * �����������췽��������Ҫ���ڳ�ʼ�����������
	 * ��j�ͷ����4�����Խ��и�ֵ����ʼ����
	 * �﷨: ������һ���ķ��������ܶ��巵��ֵ
	 */
	public J(){
		//����������Խ��и�ֵ
		c1 = new Cell();
		c1.row = 5;
		c1.col = 3;
		c2 = new Cell();
		c2.row = 5;
		c2.col = 4;
		c3 = new Cell();
		c3.row = 5;
		c3.col = 5;
		c4 = new Cell();
		c4.row = 6;
		c4.col = 5;
	}
	/*
	 * ����ķ���
	 *   1 �Ƕ������Ϊ�����ܣ�
	 *     ��ǰ������ʾ ��ǰ���������(drop)����
	 *   2 �Ƕ����������صļ�����̣��㷨��
	 *     ���书���㷨��ÿ�����ӵ���++
	 *   3 ����ķ�����Ҫʹ�� static �ؼ��֣�
	 *   4 �κ�ʱ����Ҫ���书�ܣ�ֻ��Ҫ���÷���
	 *     �Ϳ��ԡ����á������㷨��
	 */
	public void drop(){
		c1.row++;
		c2.row++;
		c3.row++;
		c4.row++;
	}
}



