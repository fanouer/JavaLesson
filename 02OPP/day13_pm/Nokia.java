package day13;
/*
 * һ������Լ̳�һ�����࣬ʵ�ֶ���ӿ�
 * ʵ�� ��implements��
 * ��ʾ��Nokia ��һ�ַ����ͬʱҲ��һ�ֽ�Ʒ
 * ���﷨�ϣ��̳�FlyingObject �������Ժͷ���
 *   ҲҪʵ��ȫ�������͵� ���󷽷���
 */
public class Nokia 
	extends FlyingObject
	implements Award, Enemy{
	
	public void move() {
		y++;
	}
	public int getAward() {
		return GIRL;
	}
	public int getScore() {
		return 100;
	}
}







