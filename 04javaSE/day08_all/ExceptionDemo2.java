package day08;
/**
 * finally��
 * finally�����쳣��������е����һ�����֡�
 * ����ֱ��д��try����������һ��catch֮��
 * finally����Ա�֤����try���еĴ����Ƿ����
 * �쳣�����еĴ��붼һ����ִ�С�
 * ͨ����finally�����ͷ���Դ�Ȳ�������ر�����
 * @author Administrator
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try {
			String str = null;
			System.out.println(str.length());
		} catch (Exception e) {
			System.out.println("������");
		} finally{
			System.out.println("finally�еĴ���ִ����!");
		} 
		System.out.println("���������!");
	}
}




