package day03;

import java.util.Date;

/**
 * java.util.Date
 * 该类用于表示一个时间点
 * 由于Date设计上存在缺陷，所以仅用它表示一个时间，
 * 而不做时间上的其他操作。
 * 其每一个实例内部维护一个long值，该值记录的是从
 * 1970年元旦到当前Date表示的时间之间所经过的毫秒差
 * @author Administrator
 *
 */
public class DateDemo1 {
	public static void main(String[] args) {
		//默认表示当前系统时间
		Date now = new Date();
		//toString对非英语地区不是很友好
		System.out.println(now);
		/*
		 * 获取内部维护的long值
		 */
		long time = now.getTime();
		System.out.println("time:"+time);
		
		/*
		 * 设置为明天这一刻的时间
		 */
		time += 1000 * 60 * 60 * 24;
		now.setTime(time);
		System.out.println(now);
		
	}
}












