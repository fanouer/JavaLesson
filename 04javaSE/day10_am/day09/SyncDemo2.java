package day09;
/**
 * 使用Synchronized块可以将一段代码括起来进行
 * 同步。
 * 因为有效的缩小同步范围可以在保证安全的前提下
 * 以高并发效率。
 * @author Administrator
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		t1.start();
		t2.start();
	}
}

class Shop{
	/**
	 * 当一个方法被synchronized修饰后，锁对象
	 * 为当前方法所属对象，即方法中的this
	 */
	public synchronized void buy(){
		try{
			Thread t = Thread.currentThread();
			System.out.println(t+"正在挑选衣服...");
			Thread.sleep(5000);
			/*
			 * 同步块的使用关键是"同步监视器",即上锁
			 * 的对象。只要保证多个线程看到的上锁对象
			 * 是同一个，既可以使多个线程排队。
			 */
//			synchronized (this) {
				System.out.println(t+"正在试衣服...");
				Thread.sleep(5000);
//			}	
			
			System.out.println(t+"结账离开...");
		}catch(Exception e){
			
		}
	}
}














