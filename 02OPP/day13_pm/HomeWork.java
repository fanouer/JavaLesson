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
		// 每个物体都飞行一步
		b.move();
		for (int i = 0; i < 4; i++) {
			all[i].move();
		}
		// 检查碰撞？
		for (int i = 0; i < 4; i++) {
			if (all[i].duang(b)) {
				System.out.println("检查到碰撞！");
				// 碰撞了以后检查 奖品、分数
				if (all[i] instanceof Award) {
					Award awd = (Award) all[i];
					int a = awd.getAward();
					System.out.println("打到奖品：" + a);
				}
				if (all[i] instanceof Enemy) {
					Enemy e = (Enemy) all[i];
					int s = e.getScore();
					System.out.println("打到分数：" + s);
				}
			}
		}

	}

}
