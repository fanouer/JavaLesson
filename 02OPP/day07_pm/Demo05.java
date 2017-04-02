package day13;

public class Demo05 {
	public static void main(String[] args) {
		/*
		 * 类型安全的转型
		 */
		test(new Nokia());
		test(new Bullet(1,1,1,1));
	}
	public static void test(
			FlyingObject obj){
		//调用obj引用对象的 getAward()方法
		//有此方法就调用，没有就不调用
		if(obj instanceof Award){
			Award awd = (Award)obj;
			int a = awd.getAward();
			System.out.println("得到奖品"+a); 
		}
	}
}


