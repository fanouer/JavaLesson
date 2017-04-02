package day11.pm;

//import cn.tedu.shooter.Bee;

public class Demo06 {
	public static void main(String[] args) {
		/*
		 * 包名.类名 称为类的全名（全限定名）
		 */
		cn.tedu.shooter.Bee bee = 
				new cn.tedu.shooter.Bee();
		//System.out.println(bee.x); 
		day11.pm.Bee b = 
				new day11.pm.Bee(); 
		Bee b2 = new Bee();
		
		java.util.Scanner s = 
			new java.util.Scanner(
				java.lang.System.in);
	}
}
class Bee{
	int n = 6;
}