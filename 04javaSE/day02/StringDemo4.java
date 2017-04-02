package day02;
/**
 * 和谐用语
 * @author Administrator
 *
 */
public class StringDemo4 {
	public static void main(String[] args) {
		String regex 
			= "(wqnmlgb|dsb|cnm|tmd|213|djb|nc|cao)";
		
		String message 
			= "wqnmlgb!你个djb!你怎么这么nc!你个大213!tmd!cao!";
		
		message = message.replaceAll(regex, "***");
		
		System.out.println(message);
	}
}







