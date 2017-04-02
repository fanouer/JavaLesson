package day09;
/**
 * 用两种模式使用匿名内部类形式创建
 * @author Administrator
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//方式1
		Thread t1 = new Thread(){
			public void run(){
				for(int i=0;i<100;i++){
					System.out.println("你是谁啊？");
				}
			}
		};
		//方式2
		Runnable runn = new Runnable(){
			public void run(){
				for(int i=0;i<100;i++){
					System.out.println("我是查水表的!");
				}
			}
		};
		Thread t2 = new Thread(runn);
		
		t1.start();
		t2.start();
		
	}
}





