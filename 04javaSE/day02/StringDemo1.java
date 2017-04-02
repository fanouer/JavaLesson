package day02;
/**
 * String支持正则表达式的方法一:
 * boolean matches(String regex)
 * 该方法会用给定的正则表达式来验证当前字符串
 * 是否满足格式要求，满足则返回true
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
			System.out.println("是一个邮箱地址");
		}else{
			System.out.println("不是一个邮箱地址");
		}
		
	}
}








