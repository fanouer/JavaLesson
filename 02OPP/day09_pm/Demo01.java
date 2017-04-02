package day09;
/*
 * Java 类中不允许存在相同签名的方法
 */
public class Demo01 {
  
	
	/*
	 * 方法签名：add int
	 */
	public int add(int num){
		return num++;
	}
	public long add(long age){
		return age++;
	}
	public int addAge(int age){
		return age++;
	}
//	/*
//	 * 方法签名：add int
//	 */
//	public int add(int age){
//		return age++;
//	}
}
