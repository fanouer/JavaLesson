package day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程提供了一个静态方法
 * static void sleep(long ms)
 * 可以阻塞运行该方法的线程指定毫秒。
 * 当一个线程进入阻塞状态时，体现的样子就是"卡住了"。
 * 这个状态介于runnable与running之间。CPU既不运行
 * 该线程，也不准备运行它。
 * 
 * 当指定的阻塞时间经过后，当前线程会解除阻塞状态，
 * 自动回到runnable状态，等待再次分配CPU时间片并
 * 开始并发运行。
 * @author Administrator
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
//		//每秒输出一次你好!
//		while(true){
//			System.out.println("你好!");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		/*
		 * 电子表
		 * 每秒钟输出当前系统时间:14:55:22
		 */
		SimpleDateFormat format
			= new SimpleDateFormat(
				"HH:mm:ss"	
			);
		
		while(true){
			System.out.println(
				format.format(new Date())
			);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}











