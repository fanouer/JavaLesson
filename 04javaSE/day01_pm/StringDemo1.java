package day01;

public class StringDemo1 {
	public static void main(String[] args) {
		/*
		 * �ַ����Ĵ���Ӧ������ʹ����������ʽ������
		 * ��Ϊ�������������ö��󣬼����ڴ濪����
		 */
		String str1 = "helloworld";
		String str2 = "helloworld";
		String str3 = "helloworld";
		//new���������ַ�������
		String str4 = new String("helloworld");
		System.out.println(str1);
		System.out.println(str4);
		System.out.println(str1==str3);
		System.out.println(str1==str4);
		
		/*
		 * �޸�str1���ַ������ݡ�
		 * �ַ����ǲ����������ı����ݣ�
		 * һ���ᴴ���¶���
		 */
		str1 = str1+"!";
		System.out.println("str1:"+str1);
		System.out.println("str3:"+str3);
		System.out.println(str1==str3);
	}
}





