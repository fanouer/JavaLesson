package day13;

public class Demo01 {

	public static void main(String[] args) {
		Bee bee = new Bee(57, 28, 49, 59);
		Bullet b=new Bullet(83, 96, 12, 27);
		//��飬���ݳ�ʼ���Ƿ���ȷ
		System.out.println("bee:"+bee.x
				+","+bee.y+","+bee.w
				+","+bee.h);
		System.out.println("b:"+b.x
				+","+b.y+","+b.w
				+","+b.h);
		
		//���֮ǰ����Ƿ���ײ
		boolean hit = bee.duang(b);
		System.out.println(hit);//false
		//���Է���
		for(int i=0; i<10; i++){
			bee.move();
			b.move();
			System.out.println("bee:"+bee.x
					+","+bee.y+","+bee.w
					+","+bee.h);
			System.out.println("b:"+b.x
					+","+b.y+","+b.w
					+","+b.h);
		}
		//�����Ժ����Ƿ���ײ
		hit = bee.duang(b);
		System.out.println(hit);//true
	}
	

}
