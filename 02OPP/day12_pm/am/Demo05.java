package day12.am;

public class Demo05 {
	public static void main(String[] args) {
		Point p1 = new Point(0,3);
		Point p2 = new Point(4,0);
		double d = Point.distance(p1, p2);
		System.out.println(d);
		/*
		 * ���� ���󷽷�(�Ǿ�̬����)ʱ����÷���
		 * �Ķ������ã��������ݸ�����this
		 */
		double z = p1.distance(p2);
		System.out.println(z); 
	}
}
class Point{
    int x;
    int y;
    
    public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
    /*
     * ���һ�������ļ������û���õ�
       ��ǰ����(this)�����ݣ��Ϳ��Զ���Ϊ
       ��̬�����ˣ�
     */
	public static double 
         distance(Point p1, Point p2){
       int a = p1.y - p2.y;
       int b = p1.x - p2.x;
       double c = Math.sqrt(a*a+b*b);
       return c;
    }
	/*
	 * ���÷����� p1.distance(p2)
	 * 
	 */
	public double distance(Point other){
		//�����������ڼ�����������:this other
		int a = this.y - other.y;
		int b = this.x - other.x;
		double c = Math.sqrt(a*a + b*b);
		return c;
	}
}






