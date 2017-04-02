package day10;

public class Demo06 {

	public static void main(String[] args) {
		int[][] wall = new int[20][10];
		wall[17][2] = 1;
		wall[17][3] = 1;

		wall[18][2] = 1;
		wall[18][4] = 1;
		wall[18][5] = 1;
		wall[18][6] = 1;
		
		wall[19][0] = 1;
		wall[19][2] = 1;
		wall[19][5] = 1;
		for(int i=0; i<20; i++){
			for(int j=0; j<10; j++ ){
				System.out.print(wall[i][j]);
			}
			System.out.println();
		}
	}
}
