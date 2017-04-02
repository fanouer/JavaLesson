package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * 队列，存储一组元素，但是存取元素必须遵循:
 * 先进先出原则
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
		 * 向队列中添加元素的方法:入队操作
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		
		System.out.println(queue);
		
		/*
		 * E poll()
		 * 从队首获取元素，同时该元素会从队列中被
		 * 移除:出队操作
		 */
		String str = queue.poll();
		System.out.println(str);
		System.out.println(queue);
		
		/*
		 * 若仅仅想引用队首元素，而不希望做出队
		 * 操作时，可以使用该方法:
		 * E peek()
		 */
		str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		
		System.out.println("开始遍历");
		while(queue.size()>0){
			str  = queue.poll();
			System.out.println(str);
		}
		System.out.println("遍历完毕");
		System.out.println(queue);
	}
}





