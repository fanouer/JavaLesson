package day13;

public class HomeWork {

	public static void main(String[] args) {

		FlyingObject[] all = new FlyingObject[4];
		all[0] = new Airplane(55, 98, 35, 29);
		all[1] = new Airplane(137, 91, 35, 29);
		all[2] = new Bee(62, 132, 32, 30);
		all[3] = new Bee(172, 137, 32, 30);
		// ...
		Bullet b = new Bullet(68, 135, 10, 15);
		// ÿ�����嶼����һ��
		b.move();
		for (int i = 0; i < 4; i++) {
			all[i].move();
		}
		// �����ײ��
		for (int i = 0; i < 4; i++) {
			if (all[i].duang(b)) {
				System.out.println("��鵽��ײ��");
				// ��ײ���Ժ��� ��Ʒ������
				if (all[i] instanceof Award) {
					Award awd = (Award) all[i];
					int a = awd.getAward();
					System.out.println("�򵽽�Ʒ��" + a);
				}
				if (all[i] instanceof Enemy) {
					Enemy e = (Enemy) all[i];
					int s = e.getScore();
					System.out.println("�򵽷�����" + s);
				}
			}
		}

	}

}
