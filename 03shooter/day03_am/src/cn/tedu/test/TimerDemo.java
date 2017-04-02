package cn.tedu.test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
	public static void main(String[] args) {
		/**
		 * Timer 定时器
		 * TimerTask 定时器任务
		 */
		/*
		 * 创建了一个定时器对象
		 */
		Timer timer = new Timer();
		/*
		 * 给定时器绑定一个定时执行的任务
		 */
		TimerTask task = new TimerTask(){
			//是任务中被执行方法
			public void run(){
				System.out.println("起床吧!");
			}
		};
		//schedule: 设定计划任务
		timer.schedule(task, 1000, 1000);
		
		 
	}
}


