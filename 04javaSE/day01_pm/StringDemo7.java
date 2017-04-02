package day01;
/**
 * char charAt(int index)
 * 获取当前字符串中指定位置上的字符
 * @author Administrator
 *
 */
public class StringDemo7 {
	public static void main(String[] args) {
		//            0123456789012345
		String str = "thinking in java";
		
		char c = str.charAt(9);
		System.out.println("char:"+c);
		
		/*
		 * 检查一个字符串是否为回文
		 * 思路:
		 * 正数位置上的字符与倒数位置上的字符
		 * 都一致就是回文。
		 */
		String info = "上海来自水来自海上";
		for(int i=0;i<info.length()/2;i++){
			if(
				info.charAt(i) 
				!=
				info.charAt(info.length()-1-i)
			){
				System.out.println("不是回文!");
				return;//结束方法
			}else{
				
			}
		}
		System.out.println("是回文!");
	}
}











