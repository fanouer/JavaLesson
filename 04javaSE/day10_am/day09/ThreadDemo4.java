package day09;
/**
 * �߳����ȼ�
 * 
 * �����̲߳��ܸ����̵߳��ȵĹ�����ֻ�ܱ���������
 * CPUʱ�䡣���Կ���ͨ���ı����ȼ������ƻ�ȡCPUʱ��
 * Ƭ�ü���
 * 
 * ���ȼ��ߵ��̻߳�ȡCPUʱ��Ƭ������
 * @author Administrator
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("max");
				}
			}
		};
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("min");
				}
			}
		};
		Thread norm = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("norm");
				}
			}
		};
		/*
		 * ���ȼ�1-10
		 * Ҳ����ʹ�ó���:
		 * MAX_PRIORITY��Ӧ����:10
		 * MIN_PRIORITY��Ӧ��С��:1
		 */
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
//		norm.setPriority(Thread.NORM_PRIORITY);
		
		min.start();
		norm.start();
		max.start();
	}
}






