package day08;

public class Demo01 {
	public static void main(String[] args) {
		//���ù�������������
		//�����˱���a1�����˷ɻ�����
		Airplane a1 = new Airplane();
		System.out.println(a1.x);
		System.out.println(a1.y);
		System.out.println(a1.w);
		System.out.println(a1.h);
		//���÷ɷ���
		a1.move();
		//���Է����Ժ������
		System.out.println(a1.x);
		System.out.println(a1.y);
		System.out.println(a1.w);
		System.out.println(a1.h);
	}
}

class Airplane {
	int w;
	int h;
	int x;
	int y;

	// ��һ�δ����ɻ�ʱ����ù�����
	public Airplane() {
		w = 38;
		h = 62;
		y = -h;
		x = (int) (Math.random() * (480 - w));// 0~(480-w)
	}

	// ���з���
	public void move() {
		y++;
	}

}
