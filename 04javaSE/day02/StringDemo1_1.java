package day02;
/**
 * String֧��������ʽ�ķ���һ:
 * boolean matches(String regex)
 * �÷������ø�����������ʽ����֤��ǰ�ַ���
 * �Ƿ������ʽҪ�������򷵻�true
 * @author Administrator
 *
 */
public class StringDemo1 {
	public static void main(String[] args) {
		String mail
			= "fancq@tedu.cn";
		/*
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+
		 * 
		 */
		String regex 
			= "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
		
		boolean match = mail.matches(regex);
		if(match){
			System.out.println("��һ�������ַ");
		}else{
			System.out.println("����һ�������ַ");
		}
		
	}
}








