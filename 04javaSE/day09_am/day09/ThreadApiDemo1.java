package day09;
/**
 * �߳��ṩ��һ����̬����
 * static Thread currentThread()
 * �÷������ȡ���ø÷������߳�
 * 
 * ����������һ������ʱ������ϵͳ������һ��������
 * ����JVM����JVM�����󣬻��Զ�����һ���߳���
 * ִ��main����������main����Ҳ�ǿ�һ���߳����еġ�
 * @author Administrator
 *
 */
public class ThreadApiDemo1 {
	public static void main(String[] args) {
		//��ȡ����main�������߳�
		Thread t = Thread.currentThread();
		
		System.out.println(
			"����main�������߳���:"+t
		);
		
		dosome();
		
		Thread t1 = new Thread(){
			public void run(){
				Thread t = Thread.currentThread();
				System.out.println("�Զ����߳�:"+t);
				dosome();
			}
		};
		
		t1.start();
		
	}
	/**
	 * ͨ���ڷ�����ʹ��currentThread����������
	 * ��ȡ���е�ǰ�������̡߳�
	 */
	public static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(
			"����dosome�������߳���:"+t
		);
	}
}






