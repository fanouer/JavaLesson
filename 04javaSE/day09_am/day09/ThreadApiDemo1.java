package day09;
/**
 * 线程提供了一个静态方法
 * static Thread currentThread()
 * 该方法会获取调用该方法的线程
 * 
 * 当我们启动一个程序时，操作系统会启动一个进程来
 * 运行JVM，当JVM启动后，会自动创建一个线程来
 * 执行main方法。所以main方法也是靠一个线程运行的。
 * @author Administrator
 *
 */
public class ThreadApiDemo1 {
	public static void main(String[] args) {
		//获取运行main方法的线程
		Thread t = Thread.currentThread();
		
		System.out.println(
			"运行main方法的线程是:"+t
		);
		
		dosome();
		
		Thread t1 = new Thread(){
			public void run(){
				Thread t = Thread.currentThread();
				System.out.println("自定义线程:"+t);
				dosome();
			}
		};
		
		t1.start();
		
	}
	/**
	 * 通常在方法中使用currentThread方法是用来
	 * 获取运行当前方法的线程。
	 */
	public static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(
			"运行dosome方法的线程是:"+t
		);
	}
}






