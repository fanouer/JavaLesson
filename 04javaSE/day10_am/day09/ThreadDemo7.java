package day09;
/**
 * void join()
 * �߳��ṩ��join����������Э���̼߳�ͬ�������ġ�
 * ��A�̵߳�����B�̵߳�join����ʱ��A�̻߳��������
 * ״̬��ֱ��B�̵߳�run����ִ������߳̽�����A�߳�
 * �Ż�������������ִ��join���������Ĵ��롣
 * @author Administrator
 *
 */
public class ThreadDemo7 {
	//��ʾͼƬ�Ƿ��������
	public static boolean isFinish = false;
	
	public static void main(String[] args) {
		/*
		 * ��һ�������еľֲ��ڲ�����Ҫ�������������
		 * �����ֲ�����ʱ���ñ���������final��
		 */
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:��ʼ����ͼƬ...");
				for(int i=1;i<=100;i++){
					System.out.println("down:������"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down:ͼƬ�������!");
				isFinish = true;
			}
		};
		Thread show = new Thread(){
			public void run(){
				System.out.println("show:��ʼ��ʾͼƬ...");
				/*
				 * Ӧ���ȴ�download��ͼƬ�������!
				 * ����show�̣߳��ȴ�dowonload������
				 * ִ����ϡ�
				 */
				try{
					download.join();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				
				if(!isFinish){
					throw new RuntimeException("ͼƬû���������!");
				}
				System.out.println("show:��ʾͼƬ��ϣ�");
			}
		};
		
		download.start();
		show.start();
	}
}







