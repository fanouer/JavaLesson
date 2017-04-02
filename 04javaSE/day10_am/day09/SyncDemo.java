package day09;
/**
 * �����߳��ǲ������У�һ������̷߳���ͬһ��Դʱ
 * �ͻ����"����"�������߳��л�ʱ���ǲ�ȷ���ģ�
 * ���������ܵ����߼����ֻ��ң�����ʱ�ᵼ��ϵͳ̱����
 * 
 * @author Administrator
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(
						getName()+":"+bean
					);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(
						getName()+":"+bean
					);
				}
			}
		};
		t1.start();
		t2.start();
	}
}

class Table{
	//��������20������
	private int beans = 20;
	/**
	 * ��һ��������sunchronized���κ󣬸÷���
	 * ��Ϊ"ͬ������"����ͬһʱ���ڣ�����̲߳���
	 * ͬʱ���ʷ����ڲ��������Ŷ�ִ�С�
	 * @return
	 */
	public synchronized int getBean(){
		if(beans == 0){
			throw new RuntimeException("û�ж�����!");
		}
		//ģ��CPUʱ�����꣬�����߳��л�
		Thread.yield();
		return beans--;
	}
}






