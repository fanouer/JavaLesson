package day01;
/**
 * boolean startsWith(String str)
 * boolean endsWith(String str)
 * �жϵ�ǰ�ַ����Ƿ����Ը��������ַ�����ʼ���β��
 * @author Administrator
 *
 */
public class StringDemo8 {
	public static void main(String[] args) {	
		String str = "thinking in java";
		
		boolean starts 
			= str.startsWith("thi");
		System.out.println("starts:"+starts);
		
		boolean ends
			= str.endsWith("a");
		System.out.println("ends:"+ends);
	}
}




