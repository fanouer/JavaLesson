package day09;
/**
 * �̴߳���������ģʽ:
 * ģʽһ:
 * �̳�Thread,����дrun�������÷������������߳�
 * Ҫִ�е�����
 * @author Administrator
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		/*
		 * ���Ⱥ�˳���ִ�У���ͬ��ִ��
		 */
//		for(int i=0;i<100;i++){
//			System.out.println("����˭��?");
//			System.out.println("���ǲ�ˮ���!");
//		}
		
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		
		t1.start();
		t2.start();
	}
}
/**
 * ��һ�ִ����̵߳ķ�ʽ�ĺô�:
 * ����򵥣�һ�����������ڲ������ʽ����ʹ�á�
 * 
 * Ҳ�����Ų���:
 * 1:����java���̳У����Ե��̳���Thread���Ͳ���
 *   �̳������࣬������Ŀʵ�������кܲ���
 * 2:���������ڵ�ǰ�߳��ڲ�ֱ����дrun���������˸���
 *   ��ִ�е�������͵������߳����߳�ִ�е�������һ��
 *   ǿ��Ϲ�ϵ���������̵߳����á�  
 * @author Administrator
 *
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("����˭��?");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("���ǲ�ˮ���!");
		}
	}
}
















