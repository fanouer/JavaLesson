package day08;
/**
 * ���Է������쳣���׳�
 * @author Administrator
 *
 */
public class ExceptionDemo3 {
	public static void main(String[] args){
		Person p = new Person();
		/*
		 * ��һ��������ʹ��throws������ĳ���쳣
		 * ���׳�ʱ�����ø÷����ͱ��봦����쳣��
		 * ���������ַ�ʽ:
		 * 1:ʹ��try-catch���񲢴�����쳣
		 * 2:�ڵ�ǰ�����ϼ���ʹ��throws�����쳣�׳�
		 */
		try {
			p.setAge(1000);
		} catch (IllegalAgeException e) {
			e.printStackTrace();
		}
	
		System.out.println("������:"+p.getAge());
	}
}


