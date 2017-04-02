package day12;
/*
 * Java Դ�ļ��﷨�涨��
 *   1 һ��java�ļ���ֻ����һ�������࣡ 
 *     �����������Ĭ�������ࣨͬ���ࣩ
 *   2 �ļ�������͹�������һ��
 *   3 ���û�й����࣬�ļ�������������һ��
 *   4 Ĭ�������ࣨͬ���ࣩ�Ŀɷ��ʷ�Χ���ǵ�ǰ��
 *     �ڲ���Ч��
 *   5 Ϊ�˱���Ĭ����ֻ���ڵ�ǰ����ʹ�ã��޷����
 *   ���ʣ�Լ����һ��java�ļ�һ�������࣡
 *
 * day12
 *   |--Demo01.java
 *       |-- public class Demo01
 *       |-- class Point
 * day12.am
 *   |-- Demo02{
 *         main(){
 *           Point ���ܷ���
 *           Demo01 ���Է���
 *         }
 *       }
 *          
 *   
 *  
 *
 */

public class Demo01 {
	public static void main(String[] args) {
		Point p = new Point(5,0);
		//System.out.println(p.x);//�����
		/*
		 * �������÷�����ȡ���������
		 * ������ֻ���ģ����Կ������ԵĶ�д
		 */
		System.out.println(p.getX()); //5
		p.setX(6);
		System.out.println(p.getX()); //6
	}
}
class Point{
	private int x;
	private int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	/* ���Է��ʷ�����getX ���ڶ�ȡ����
	 * setX �����޸����� */
	//public int getX(){
		//���봦���߼�
	//	return x;
	//}
	/*
	 * setX���������޸����ԣ�����Ҫ����ֵ
	 * ���������޸ĵ�ֵ
	 */
	//public void setX(int x){
		//���봦���߼�
	//	this.x = x;
		//���봦���߼�
	//}
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
}

