package day03;

import java.util.Date;

/**
 * java.util.Date
 * �������ڱ�ʾһ��ʱ���
 * ����Date����ϴ���ȱ�ݣ����Խ�������ʾһ��ʱ�䣬
 * ������ʱ���ϵ�����������
 * ��ÿһ��ʵ���ڲ�ά��һ��longֵ����ֵ��¼���Ǵ�
 * 1970��Ԫ������ǰDate��ʾ��ʱ��֮���������ĺ����
 * @author Administrator
 *
 */
public class DateDemo1 {
	public static void main(String[] args) {
		//Ĭ�ϱ�ʾ��ǰϵͳʱ��
		Date now = new Date();
		//toString�Է�Ӣ��������Ǻ��Ѻ�
		System.out.println(now);
		/*
		 * ��ȡ�ڲ�ά����longֵ
		 */
		long time = now.getTime();
		System.out.println("time:"+time);
		
		/*
		 * ����Ϊ������һ�̵�ʱ��
		 */
		time += 1000 * 60 * 60 * 24;
		now.setTime(time);
		System.out.println(now);
		
	}
}












