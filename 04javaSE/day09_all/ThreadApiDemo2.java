package day09;
/**
 * ��ȡ�߳������Ϣ�ķ���
 * @author Administrator
 *
 */
public class ThreadApiDemo2 {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		//��ȡid
		long id = t.getId();
		System.out.println("id:"+id);
		//��ȡ����
		String name = t.getName();
		System.out.println("name:"+name);
		//��ȡ���ȼ�
		int priority = t.getPriority();
		System.out.println("���ȼ�:"+priority);
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









