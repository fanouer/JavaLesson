package day09;
/**
 * ������
 * ��synchronized���ε������β�ͬ�Ĵ��룬����
 * ��������ͬʱ�������̷ֱ߳���������δ���ʱ����
 * ����ġ�
 * @author Administrator
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Boo b = new Boo();
		Thread t1 = new Thread(){
			public void run(){
				b.methodA();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				b.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}
class Boo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		System.out.println(t+"����ִ��A����...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t+"ִ��A�������!");
	}
	public synchronized void methodB(){
		Thread t = Thread.currentThread();
		System.out.println(t+"����ִ��B����...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t+"ִ��B�������!");
	}
}







