package day09;
/**
 * void join()
 * 线程提供了join方法是用来协调线程间同步工作的。
 * 当A线程调用了B线程的join方法时，A线程会进入阻塞
 * 状态，直到B线程的run方法执行完毕线程结束后，A线程
 * 才会解除阻塞，继续执行join方法后续的代码。
 * @author Administrator
 *
 */
public class ThreadDemo7 {
	//表示图片是否下载完毕
	public static boolean isFinish = false;
	
	public static void main(String[] args) {
		/*
		 * 当一个方法中的局部内部类中要引用这个方法的
		 * 其他局部变量时，该变量必须是final的
		 */
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:开始下载图片...");
				for(int i=1;i<=100;i++){
					System.out.println("down:已下载"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down:图片下载完毕!");
				isFinish = true;
			}
		};
		Thread show = new Thread(){
			public void run(){
				System.out.println("show:开始显示图片...");
				/*
				 * 应当等待download将图片下载完毕!
				 * 阻塞show线程，等待dowonload将任务
				 * 执行完毕。
				 */
				try{
					download.join();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				
				if(!isFinish){
					throw new RuntimeException("图片没有下载完毕!");
				}
				System.out.println("show:显示图片完毕！");
			}
		};
		
		download.start();
		show.start();
	}
}







