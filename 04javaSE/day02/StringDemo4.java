package day02;
/**
 * ��г����
 * @author Administrator
 *
 */
public class StringDemo4 {
	public static void main(String[] args) {
		String regex 
			= "(wqnmlgb|dsb|cnm|tmd|213|djb|nc|cao)";
		
		String message 
			= "wqnmlgb!���djb!����ô��ônc!�����213!tmd!cao!";
		
		message = message.replaceAll(regex, "***");
		
		System.out.println(message);
	}
}







