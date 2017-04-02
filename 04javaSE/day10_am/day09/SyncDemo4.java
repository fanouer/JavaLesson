package day09;
/**
 * 互斥锁
 * 当synchronized修饰的是两段不同的代码，但是
 * 锁对象相同时，两个线程分别调用这两段代码时就是
 * 互斥的。
 * @author Administrator
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Boo b = new Boo();
		Thread t1 = new Thread(){
			public void run(){
				b.methodA();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				b.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}
class Boo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		System.out.println(t+"正在执行A方法...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t+"执行A方法完毕!");
	}
	public synchronized void methodB(){
		Thread t = Thread.currentThread();
		System.out.println(t+"正在执行B方法...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t+"执行B方法完毕!");
	}
}







