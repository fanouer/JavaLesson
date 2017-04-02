package day09;
/**
 * ʹ��Synchronized����Խ�һ�δ�������������
 * ͬ����
 * ��Ϊ��Ч����Сͬ����Χ�����ڱ�֤��ȫ��ǰ����
 * �Ը߲���Ч�ʡ�
 * @author Administrator
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		t1.start();
		t2.start();
	}
}

class Shop{
	/**
	 * ��һ��������synchronized���κ�������
	 * Ϊ��ǰ�����������󣬼������е�this
	 */
	public synchronized void buy(){
		try{
			Thread t = Thread.currentThread();
			System.out.println(t+"������ѡ�·�...");
			Thread.sleep(5000);
			/*
			 * ͬ�����ʹ�ùؼ���"ͬ��������",������
			 * �Ķ���ֻҪ��֤����߳̿�������������
			 * ��ͬһ�����ȿ���ʹ����߳��Ŷӡ�
			 */
//			synchronized (this) {
				System.out.println(t+"�������·�...");
				Thread.sleep(5000);
//			}	
			
			System.out.println(t+"�����뿪...");
		}catch(Exception e){
			
		}
	}
}














