package day13;
/**
 * ������
 */
public abstract class FlyingObject {
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	
	/**
	 * �������ƶ��������������ʵ�֣���д��
	 * ʵ�־���ķ��й켣
	 */
	public abstract void move();
	/** ��鵱ǰ�������Ƿ�������һ����������ײ */
	public boolean duang(FlyingObject other){
		int x1 = this.x - other.w;
		int x2 = this.x + this.w;
		int y1 = this.y - other.h;
		int y2 = this.y + this.h;
		System.out.println(
			"x1:"+x1+" x2:"+x2+
			" y1:"+y1+" y2:"+y2+
			" other.x:"+x+" other.y:"+other.y);
		//x1<other.x<x2 && y1<other.y<y2
		return x1<other.x && other.x<x2
			&& y1<other.y && other.y<y2;
	}
}










