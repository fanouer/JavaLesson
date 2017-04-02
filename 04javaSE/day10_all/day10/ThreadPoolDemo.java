package day10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳�
 * ʹ���̳߳���Ҫ���Խ����������:
 * 1:�����߳�����
 * 2:�����߳�
 * 
 * ����ʵ����:�̶���С�̳߳�
 * @author Administrator
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService threadPool
			= Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			Runnable runn = new Runnable(){
				public void run(){
					Thread t = Thread.currentThread();
					System.out.println(t+"����ִ������...");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("�̱߳��ж��ˣ�");
					}
					System.out.println(t+"ִ���������!");
				}
			};
			System.out.println("�����񽻸��̳߳�...");
			threadPool.execute(runn);
		}
		/*
		 * �̳߳��ṩ���������ڹرյķ���:
		 * shutdown:
		 * ����ǰ�̳߳�����������ִ����Ϻ󣬾�
		 * �ر��̳߳ء�
		 * 
		 * shutdownNow:
		 * ���۵�ǰ�̳߳����Ƿ��������Լ��߳�
		 * �Ƿ�����ִ�����񣬶���ǿ�ƽ��߳��жϣ�
		 * ʹ�̳߳عرա�
		 */
		threadPool.shutdownNow();
		System.out.println("�ر����̳߳�!");
	}
}







