package day02;
/**
 * String replaceAll(String regex,String str)
 * 将当前字符串中满足正则表达式的部分替换为给定
 * 的字符串
 * @author Administrator
 *
 */
public class StringDemo3 {
	public static void main(String[] args) {
		String str = "abc123def456ghi789jut765kil";
		/*
		 * 将数字部分替换为"#NUMBER#"
		 */
		str = str.replaceAll("[0-9]+", "#NUMBER#");
		System.out.println(str);
		
	}
}




