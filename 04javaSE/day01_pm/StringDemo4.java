package day01;
/**
 * int indexOf(String str)
 * ���Ҹ����ַ����ڵ�ǰ�ַ����е�λ�á�
 * ����ǰ�ַ����в����и����ַ����򷵻�ֵΪ-1��
 * ���򷵻ص�λ��Ϊ�����ַ�����һ���ַ��ڵ�ǰ
 * �ַ����е�λ�á�
 * @author Administrator
 *
 */
public class StringDemo4 {
	public static void main(String[] args) {
		//java���˼��
		//            0123456789012345
		String str = "thinking in java";
		
		int index = str.indexOf("in");
		System.out.println("index:"+index);
		
		/*
		 * ���ط��������ָ��λ�ô���ʼ����
		 */
		index = str.indexOf("in",3);
		System.out.println("index:"+index);
		
		/*
		 * int lastIndexOf(String str)
		 * �������һ�γ��ֵ�λ��
		 */
		int last = str.lastIndexOf("in");
		System.out.println("last:"+last);
	}
}





