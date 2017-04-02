package day05;
/**
 * �������ڲ�����Ϊ����Ԫ�ؽ�������ʹ��
 * @author Administrator
 *
 */
public class Point implements Comparable<Point>{
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "("+x+","+y+")";
	}
	
	/**
	 * �÷����Ƕ���Ƚϴ�С�Ĺ������жϵ�ǰ����
	 * ������Ĳ�������Ƚϡ�
	 * ����ֵ�����ľ���ֵ��ֻ��עȡֵ��Χ:
	 * ������ֵ>0:��ǰ����Ȳ��������
	 * ������ֵ<0:��ǰ����Ȳ�������С
	 * ������ֵ=0:����������� 
	 * 
	 */
	public int compareTo(Point o) {
		int len = this.x*this.x+this.y*this.y;
		int olen = o.x*o.x+o.y*o.y;
		return len-olen;
	}
	
	
}





