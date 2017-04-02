package day09;
/**
 * 方式二:
 * 单独定义线程任务:定义一个类并实现Runnable接口
 * 然后重写run方法定义任务。
 * 好处:
 * 由于是实现接口，java接口可以多实现，所以既不影响
 * 其他接口的实现，也不影响类的继承。
 * 由于是单独定义任务，所以与线程没有必然的耦合关系，
 * 利于线程的重用。
 * @author Administrator
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		
		Runnable runn1 = new MyRunnable1();
		Runnable runn2 = new MyRunnable2();

		Thread t1 = new Thread(runn1);
		Thread t2 = new Thread(runn2);
		
		t1.start();
		t2.start();
		
	}
}

class MyRunnable1 implements Runnable{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("你是谁啊?");
		}
	}
}
class MyRunnable2 implements Runnable{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("我是修水管的!");
		}
	}
}






