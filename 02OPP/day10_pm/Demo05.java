package day10;

public class Demo05 {

	public static void main(String[] args) {
		//���ó��ȳ�ʼ��2ά����
		int row = 3;
		int col = 4;
		int[][] ary = new int[row][col];
		System.out.println(ary[1][1]);

		//System.out.println(ary[0~2][0~3]);
		//����ѭ���������ÿ��Ԫ��
		for(int i=0; i<3; i++){
		   for(int j=0; j<4; j++){
			 //ary[i][j]=?
		     System.out.print(ary[i][j]);
		   }
		   System.out.println();
		}
		//ʹ��Ԫ��ֱ�ӳ�ʼ������
		int[][] ary2 = {{1,2},{2,4},{3,3}};
		System.out.println(ary[1][1]);
	}

}
