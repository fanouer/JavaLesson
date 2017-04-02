package day09;
/**
 * 静态方法锁
 * 当一个静态方法被synchronized修饰后，该方法
 * 一定具有同步效果。
 * 静态方法上锁的对象为当前类对象(Class类的实例)。
 * JVM在加载一个类时，会实例化一个Class的实例用来
 * 描述这个类，所以每个类在JVM内部都有且只有一个Class
 * 的实例，静态方法就是将该对象加锁的
 * @author Administrator
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		final Foo f1 = new Foo();
		final Foo f2 = new Foo();
		Thread t1 = new Thread(){
			public void run(){
				f1.dosome();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				f2.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}

class Foo{
	/**
	 * 静态方法若被synchronized修饰后一定具有
	 * 同步效果。
	 */
	public synchronized static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(t+"正在执行dosome方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t+"执行方法dosome完毕!");
	}
}






