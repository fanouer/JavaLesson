package cn.tedu.test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
	public static void main(String[] args) {
		/**
		 * Timer ��ʱ��
		 * TimerTask ��ʱ������
		 */
		/*
		 * ������һ����ʱ������
		 */
		Timer timer = new Timer();
		/*
		 * ����ʱ����һ����ʱִ�е�����
		 */
		TimerTask task = new TimerTask(){
			//�������б�ִ�з���
			public void run(){
				System.out.println("�𴲰�!");
			}
		};
		//schedule: �趨�ƻ�����
		timer.schedule(task, 1000, 1000);
		
		 
	}
}


