package cn.tedu.shooter;
/**
 * С�ɻ����Ƿ�����Ҳ�ǵ��� 
 */
public class Airplane 
	extends FlyingObject
	implements Enemy{
	/**
	 * �����ٶȣ����ù�������ʼ��Ϊ 1~3�����
	 */
	private int speed; 
	
	public int getScore() {
		return 1;
	}
	public void move() {
		y+=speed;
	}
}
