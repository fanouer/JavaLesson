package day09;
/**
 * 由于线程是并发运行，一旦多个线程访问同一资源时
 * 就会出现"争抢"的现象，线程切换时机是不确定的，
 * 这样做可能导致逻辑出现混乱，严重时会导致系统瘫痪。
 * 
 * @author Administrator
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(
						getName()+":"+bean
					);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(
						getName()+":"+bean
					);
				}
			}
		};
		t1.start();
		t2.start();
	}
}

class Table{
	//桌子上有20个豆子
	private int beans = 20;
	/**
	 * 当一个方法被sunchronized修饰后，该方法
	 * 变为"同步方法"，在同一时间内，多个线程不能
	 * 同时访问方法内部。必须排队执行。
	 * @return
	 */
	public synchronized int getBean(){
		if(beans == 0){
			throw new RuntimeException("没有豆子了!");
		}
		//模拟CPU时间用完，发生线程切换
		Thread.yield();
		return beans--;
	}
}






