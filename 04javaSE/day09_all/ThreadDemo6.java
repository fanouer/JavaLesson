package day09;
/**
 * 守护线程
 * 
 * 进程的结束:
 * 当一个进程中的所有前台线程结束，进程就结束了。
 * 
 * 守护线程也称为后台线程，使用上与前台线程一致，但是
 * 结束时机不完全一样，当一个进程结束时，无论后台线程
 * 是否还在运行都要强制结束。
 * 
 * @author Administrator
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		
		/*
		 * rose:扮演者为前台线程
		 */
		Thread rose = new Thread(){
			public void run(){
				for(int i = 0;i<10;i++){
					System.out.println(
						"rose:let me go!"
					);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				System.out.println(
					"rose:啊啊啊啊AAAAAAaaaaa...."
				);
				System.out.println("效果:噗通!");
			}
		};
		/*
		 * jack:扮演者后台线程
		 */
		Thread jack = new Thread(){
			public void run(){
				while(true){
					System.out.println(
						"jack:you jump!i jump!"
					);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		//设置为后台线程
		jack.setDaemon(true);
		
		rose.start();
		jack.start();
	
//		while(true){
//			
//		}
	}
}








