package cn.tedu.shooter;
/** ��ɻ����ͣ��ǵ���Ҳ�ǽ�Ʒ */
public class BigPlane
	extends FlyingObject
	implements Enemy, Award{
	
	private int award;//���ù�������ʼ��
	
	public int getAward() {
		return award;
	}
	public int getScore() {
		return 5;
	}
	public void move() {
		y+=2;
	}
}
