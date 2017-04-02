package day09;
/**
 * 获取线程相关信息的方法
 * @author Administrator
 *
 */
public class ThreadApiDemo2 {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		//获取id
		long id = t.getId();
		System.out.println("id:"+id);
		//获取名字
		String name = t.getName();
		System.out.println("name:"+name);
		//获取优先级
		int priority = t.getPriority();
		System.out.println("优先级:"+priority);
		//isAlive
		boolean isAlive = t.isAlive();
		System.out.println("isAlive:"+isAlive);
		//isDaemon
		boolean isDaemon = t.isDaemon();
		System.out.println("isDaemon:"+isDaemon);
		//isInterrupted
		boolean isInt = t.isInterrupted();
		System.out.println("isInterrypted:"+isInt);
		
		
		
	}
}









