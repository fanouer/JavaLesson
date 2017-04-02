package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * ���У��洢һ��Ԫ�أ����Ǵ�ȡԪ�ر�����ѭ:
 * �Ƚ��ȳ�ԭ��
 * 
 * @author Administrator
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue
			= new LinkedList<String>();
		/*
		 * boolean offer(E e)
		 * ����������Ԫ�صķ���:��Ӳ���
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		
		System.out.println(queue);
		
		/*
		 * E poll()
		 * �Ӷ��׻�ȡԪ�أ�ͬʱ��Ԫ�ػ�Ӷ����б�
		 * �Ƴ�:���Ӳ���
		 */
		String str = queue.poll();
		System.out.println(str);
		System.out.println(queue);
		
		/*
		 * �����������ö���Ԫ�أ�����ϣ��������
		 * ����ʱ������ʹ�ø÷���:
		 * E peek()
		 */
		str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		
		System.out.println("��ʼ����");
		while(queue.size()>0){
			str  = queue.poll();
			System.out.println(str);
		}
		System.out.println("�������");
		System.out.println(queue);
	}
}





