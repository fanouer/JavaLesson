package day08;
/**
 * �쳣���÷���
 * @author Administrator
 *
 */
public class ExceptionApiDemo {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try {
			String str = "a";
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			/*
			 * ��������ջ�������ڶ�λ�쳣����
			 * ��λ�ã���������
			 */
//			e.printStackTrace();
			//��ȡ������Ϣ
			String message = e.getMessage();
			System.out.println(message);
			
		}
		System.out.println("���������");
	}
}


