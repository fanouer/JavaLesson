package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ջ�ṹ
 * �洢һ��Ԫ�أ���ȡԪ�ر�����ѭ:
 * �Ƚ����ԭ��
 * @author Administrator
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		Deque<String> stack
			= new LinkedList<String>();
		
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");		
		System.out.println(stack);
		
		String str = stack.pop();
		System.out.println(str);
		System.out.println(stack);
		
		str = stack.peek();
		System.out.println(str);
		System.out.println(stack);
		
		while(stack.size()>0){
			str = stack.pop();
			System.out.println(str);
		}
		System.out.println(stack);
	}
}






