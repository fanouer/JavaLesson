package day08;
/**
 * 异常常用方法
 * @author Administrator
 *
 */
public class ExceptionApiDemo {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = "a";
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			/*
			 * 输出错误堆栈，有助于定位异常出现
			 * 的位置，调整代码
			 */
//			e.printStackTrace();
			//获取错误消息
			String message = e.getMessage();
			System.out.println(message);
			
		}
		System.out.println("程序结束了");
	}
}


