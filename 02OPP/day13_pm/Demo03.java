package day13;

/*
 * ���������﷨
 */
public class Demo03 {

	public static void main(String[] args) {
		Bullet bullet = 
				new Bullet(1, 1, 0, 0);
		//��������:ֻ������Ϊ������(�ࡢ�ӿ�)
		FlyingObject obj = bullet;
		//û��ʵ�ֽӿ�,û�м̳й�ϵ��������
		//Award awd = bullet;
		//Bee b = bullet;
		//
		//ע�⣺Java�������������ͼ����÷����Ƿ�ƥ��
		// û�еķ�����������ã�
		Award awd = new Nokia();
		//awd ������ Award �� getAward ����
		int a = awd.getAward();
		// awd û��getScore() �����Ͳ���
		// ���ã�
		//int s = awd.getScreo();//������� 
		
	}
}








