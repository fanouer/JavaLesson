package day02;
/**
 * �������ڲ���Object��ط�������д
 * @author Administrator
 */
public class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	/**
	 * ��������Ҫʹ��һ�����equals�����Ƚ�����
	 * ���������Ƿ�һ��("����")ʱ����Ӧ����д
	 * �÷�����JAVA API�ṩ��������϶���д���ˡ�
	 */
	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		if(o == this){
			return true;
		}
		if(o instanceof Point){
			Point p = (Point)o;
			return this.x==p.x&&this.y==p.y;
		}		
		
		return false;
	}
}








