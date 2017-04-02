package day09;
/**
 * 线程创建有两种模式:
 * 模式一:
 * 继承Thread,并重写run方法，该方法用来定义线程
 * 要执行的任务。
 * @author Administrator
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		/*
		 * 有先后顺序的执行，是同步执行
		 */
//		for(int i=0;i<100;i++){
//			System.out.println("你是谁啊?");
//			System.out.println("我是查水表的!");
//		}
		
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		
		t1.start();
		t2.start();
	}
}
/**
 * 第一种创建线程的方式的好处:
 * 定义简单，一般用于匿名内部类的形式创建使用。
 * 
 * 也存在着不足:
 * 1:由于java单继承，所以当继承了Thread类后就不能
 *   继承其他类，这在项目实际运用中很不灵活。
 * 2:由于我们在当前线程内部直接重写run方法定义了该线
 *   程执行的任务，这就导致了线程与线程执行的任务有一个
 *   强耦合关系，不利于线程的重用。  
 * @author Administrator
 *
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("你是谁啊?");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("我是查水表的!");
		}
	}
}
















