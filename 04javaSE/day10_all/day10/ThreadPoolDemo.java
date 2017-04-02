package day10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 使用线程池主要可以解决两个问题:
 * 1:控制线程数量
 * 2:重用线程
 * 
 * 常用实现类:固定大小线程池
 * @author Administrator
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService threadPool
			= Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			Runnable runn = new Runnable(){
				public void run(){
					Thread t = Thread.currentThread();
					System.out.println(t+"正在执行任务...");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("线程被中断了！");
					}
					System.out.println(t+"执行任务完毕!");
				}
			};
			System.out.println("将任务交给线程池...");
			threadPool.execute(runn);
		}
		/*
		 * 线程池提供了两个用于关闭的方法:
		 * shutdown:
		 * 当当前线程池中所有任务都执行完毕后，就
		 * 关闭线程池。
		 * 
		 * shutdownNow:
		 * 无论当前线程池中是否还有任务，以及线程
		 * 是否正在执行任务，都会强制将线程中断，
		 * 使线程池关闭。
		 */
		threadPool.shutdownNow();
		System.out.println("关闭了线程池!");
	}
}







