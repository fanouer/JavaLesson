package day11.pm;

public class Point {
	/*
	 * ˽�����ԣ����������ڲ����Կ���
	 * x �� y ����װ������ڲ���
	 */
	private int x;
	private int y;
	public int z;
	/*
	 * Ĭ�ϵķ��ʷ�Χ����ǰ������Ч��day11.pm
	 */
	int t;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		z = 6;
		t = 100;
	}
	public void test(){
		System.out.println(x+","+y); 
	}
}
