package day09;
/**
 * ������ģʽʹ�������ڲ�����ʽ����
 * @author Administrator
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//��ʽ1
		Thread t1 = new Thread(){
			public void run(){
				for(int i=0;i<100;i++){
					System.out.println("����˭����");
				}
			}
		};
		//��ʽ2
		Runnable runn = new Runnable(){
			public void run(){
				for(int i=0;i<100;i++){
					System.out.println("���ǲ�ˮ���!");
				}
			}
		};
		Thread t2 = new Thread(runn);
		
		t1.start();
		t2.start();
		
	}
}





