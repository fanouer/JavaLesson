package day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �߳��ṩ��һ����̬����
 * static void sleep(long ms)
 * �����������и÷������߳�ָ�����롣
 * ��һ���߳̽�������״̬ʱ�����ֵ����Ӿ���"��ס��"��
 * ���״̬����runnable��running֮�䡣CPU�Ȳ�����
 * ���̣߳�Ҳ��׼����������
 * 
 * ��ָ��������ʱ�侭���󣬵�ǰ�̻߳�������״̬��
 * �Զ��ص�runnable״̬���ȴ��ٴη���CPUʱ��Ƭ��
 * ��ʼ�������С�
 * @author Administrator
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
//		//ÿ�����һ�����!
//		while(true){
//			System.out.println("���!");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		/*
		 * ���ӱ�
		 * ÿ���������ǰϵͳʱ��:14:55:22
		 */
		SimpleDateFormat format
			= new SimpleDateFormat(
				"HH:mm:ss"	
			);
		
		while(true){
			System.out.println(
				format.format(new Date())
			);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}











