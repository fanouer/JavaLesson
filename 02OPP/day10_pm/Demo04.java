package day10;

public class Demo04 {
	public static void main(String[] args) {
		/**
		 * 元素是数组的数组，称为2维数组
		 */
		int[][] ary = new int[3][];
		System.out.println(ary[0]);//null
		ary[0] = new int[]{4,5,6};
		System.out.println(ary[0][0]);//4
		ary[1] = new int[]{3,4};
		System.out.println(ary[1][0]);//3
		System.out.println(ary[2][0]);//异常
	}

}
