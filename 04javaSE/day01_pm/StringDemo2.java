package day01;

public class StringDemo2 {
	public static void main(String[] args) {
		String s1 = "123abc";
		String s2 = "123abc";
		/*
		 * java�ȱ��������
		 * �������ڼ䣬����������һ��������ʽ����
		 * ��������ݶ�������������ֱ�����㣬�����
		 * ���뵽class�ļ���
		 * String s3 = "123abc";
		 */
		String s3 = "123"+"abc";
		
		String s = "123";
		String s4 = s + "abc";
		//�ַ����������ӻ�������
		String s5 = '1'+23+"abc";
		
		String s6 = "1"+23+"abc";
		
		System.out.println("s1==s2:"+(s1==s2));
		System.out.println("s1==s3:"+(s1==s3));
		System.out.println("s1==s4:"+(s1==s4));
		System.out.println("s1==s5:"+(s1==s5));
		System.out.println("s1==s6:"+(s1==s6));
	}
}
