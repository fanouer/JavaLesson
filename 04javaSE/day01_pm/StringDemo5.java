package day01;
/**
 * String substring(int start,int end)
 * ��ȡ��ǰ�ַ�������start����ʼ��ȡ��endΪֹ��
 * ���ǲ�����end�����ַ���
 * ��JAVA API��ͨ�����������ֱ�ʾ��Χʱ������
 * "��ͷ����β"�ġ�
 * 
 * @author Administrator
 *
 */
public class StringDemo5 {
	public static void main(String[] args) {
		//            01234567890123
		String str = "www.oracle.com";
		//��ȡoracle
		String sub = str.substring(4,10);
		System.out.println(sub);
		
		/*
		 * ����һ������һ�������ķ��������Ǵ�
		 * ָ��λ�ÿ�ʼ������ȡ���ַ���ĩβ
		 */
		sub = str.substring(4);
		System.out.println(sub);
	}
}





