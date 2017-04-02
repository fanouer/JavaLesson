package day11;

public class Demo04 {
	public static void main(String[] args) {
		Airplane a = new Airplane();
		Bee bee = new Bee();
		
		//�ɻ���������
		a.move();
		System.out.println(a.x+","+a.y);
		//�۷�б������
		bee.move();
		System.out.println(bee.x+","+bee.y);
		//�����۷����һ���Ƿ����˷�������
		for(int i=0; i<500; i++){
			bee.move();
		}
		System.out.println(bee.x+","+bee.y);
		
		//ʹ�ø����Ͷ���ı������������������͵�
		//ʵ��(�����Ͷ���) 
		FlyingObject obj = new Bee();
		// ʹ�ø����ͱ���������д�ķ���ʱ��ִ��
		// �ķ�������������д�ķ���������ķ�����
		// ���ǣ����Σ��ˣ�
		obj.move();
		System.out.println(obj.x+","+obj.y);
	}
}
/*
 * ������е�����
 */
class FlyingObject{
	int x;
	int y; 
	int w;
	int h;
	public void move(){
		y++;
	}
}
class Airplane extends FlyingObject{
	//������
}
class BigPlane extends FlyingObject{

}
class Bee extends FlyingObject{
	int direction;//�۷�ķ��з���
	public Bee() {
		direction = 1;
		w = 40;
	}
	/*
	 * ����������д����ķ������޸ĸ������Ϊ
	 * �޸�Ϊб������
	 */
	public void move() {
		//y++;
		/*
		 * �����������д���෽��������Ҫ�õ�
		 * �����ṩ���㷨���Ϳ���ʹ��super.move()
		 * ���е��ã��ﵽ�����㷨��Ŀ�ġ�
		 */
		super.move();
		if(x > 480 - w){
			direction = -1;
		}
		if(x<0){
			direction = 1;
		}
		x+=direction;
	}
}

















