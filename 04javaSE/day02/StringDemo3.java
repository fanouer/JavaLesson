package day02;
/**
 * String replaceAll(String regex,String str)
 * ����ǰ�ַ���������������ʽ�Ĳ����滻Ϊ����
 * ���ַ���
 * @author Administrator
 *
 */
public class StringDemo3 {
	public static void main(String[] args) {
		String str = "abc123def456ghi789jut765kil";
		/*
		 * �����ֲ����滻Ϊ"#NUMBER#"
		 */
		str = str.replaceAll("[0-9]+", "#NUMBER#");
		System.out.println(str);
		
	}
}




