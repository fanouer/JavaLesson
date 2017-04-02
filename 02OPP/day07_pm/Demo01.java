package day13;

public class Demo01 {

	public static void main(String[] args) {
		Bee bee = new Bee(57, 28, 49, 59);
		Bullet b=new Bullet(83, 96, 12, 27);
		//检查，数据初始化是否正确
		System.out.println("bee:"+bee.x
				+","+bee.y+","+bee.w
				+","+bee.h);
		System.out.println("b:"+b.x
				+","+b.y+","+b.w
				+","+b.h);
		
		//起飞之前检查是否碰撞
		boolean hit = bee.duang(b);
		System.out.println(hit);//false
		//各自飞行
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
		//飞行以后检查是否碰撞
		hit = bee.duang(b);
		System.out.println(hit);//true
	}
	

}
