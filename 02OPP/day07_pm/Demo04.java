package day13;

public class Demo04 {

	public static void main(String[] args) {
		/*
		 * ǿ��ת��
		 */
		Award awd = new Nokia();
		int a = awd.getAward();
		// �����Ҫ���� getScore();
		// awd.getScore();
		Enemy e = (Enemy) awd;
		int n = e.getScore();
		//�����Ҫ���� move ��������Ҫת��Ϊ
		// FlyingObject 
		FlyingObject o = (FlyingObject) awd;
		o.move();
		
		// ǿ��ת�����з��յģ�ʹ���������
		// ���´��� û������
		o = new Nokia();
		o.move();
		//o���õĶ���ȷʵ��Award�������ͣ�ת���ɹ�
		Award ax = (Award) o;
		ax.getAward();
		//���´�����������쳣
		o = new Bullet(1, 1, 1, 1);
		o.move();
		//o���õĶ�����Awaed���࣬ת��ʧ��
		ax = (Award) o;//�����쳣
		ax.getAward();
	}

}
