package day09;
/**
 * �ػ��߳�
 * 
 * ���̵Ľ���:
 * ��һ�������е�����ǰ̨�߳̽��������̾ͽ����ˡ�
 * 
 * �ػ��߳�Ҳ��Ϊ��̨�̣߳�ʹ������ǰ̨�߳�һ�£�����
 * ����ʱ������ȫһ������һ�����̽���ʱ�����ۺ�̨�߳�
 * �Ƿ������ж�Ҫǿ�ƽ�����
 * 
 * @author Administrator
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		
		/*
		 * rose:������Ϊǰ̨�߳�
		 */
		Thread rose = new Thread(){
			public void run(){
				for(int i = 0;i<10;i++){
					System.out.println(
						"rose:let me go!"
					);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				System.out.println(
					"rose:��������AAAAAAaaaaa...."
				);
				System.out.println("Ч��:��ͨ!");
			}
		};
		/*
		 * jack:�����ߺ�̨�߳�
		 */
		Thread jack = new Thread(){
			public void run(){
				while(true){
					System.out.println(
						"jack:you jump!i jump!"
					);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		//����Ϊ��̨�߳�
		jack.setDaemon(true);
		
		rose.start();
		jack.start();
	
//		while(true){
//			
//		}
	}
}








