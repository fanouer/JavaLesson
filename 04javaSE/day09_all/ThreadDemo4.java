package day09;
/**
 * 线程优先级
 * 
 * 由于线程不能干涉线程调度的工作，只能被动被分配
 * CPU时间。所以可以通过改变优先级来改善获取CPU时间
 * 片得几率
 * 
 * 优先级高的线程获取CPU时间片次数多
 * @author Administrator
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("max");
				}
			}
		};
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("min");
				}
			}
		};
		Thread norm = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("norm");
				}
			}
		};
		/*
		 * 优先级1-10
		 * 也可以使用常量:
		 * MAX_PRIORITY对应最大的:10
		 * MIN_PRIORITY对应最小的:1
		 */
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
//		norm.setPriority(Thread.NORM_PRIORITY);
		
		min.start();
		norm.start();
		max.start();
	}
}






