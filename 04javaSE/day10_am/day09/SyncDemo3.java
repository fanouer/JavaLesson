package day09;
/**
 * ��̬������
 * ��һ����̬������synchronized���κ󣬸÷���
 * һ������ͬ��Ч����
 * ��̬���������Ķ���Ϊ��ǰ�����(Class���ʵ��)��
 * JVM�ڼ���һ����ʱ����ʵ����һ��Class��ʵ������
 * ��������࣬����ÿ������JVM�ڲ�������ֻ��һ��Class
 * ��ʵ������̬�������ǽ��ö��������
 * @author Administrator
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		final Foo f1 = new Foo();
		final Foo f2 = new Foo();
		Thread t1 = new Thread(){
			public void run(){
				f1.dosome();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				f2.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}

class Foo{
	/**
	 * ��̬��������synchronized���κ�һ������
	 * ͬ��Ч����
	 */
	public synchronized static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(t+"����ִ��dosome����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t+"ִ�з���dosome���!");
	}
}






