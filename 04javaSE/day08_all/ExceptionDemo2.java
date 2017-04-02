package day08;
/**
 * finally块
 * finally块是异常捕获机制中的最后一个部分。
 * 可以直接写在try后面或者最后一个catch之后。
 * finally块可以保证无论try块中的代码是否出现
 * 异常，其中的代码都一定会执行。
 * 通常在finally中做释放资源等操作，如关闭流。
 * @author Administrator
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = null;
			System.out.println(str.length());
		} catch (Exception e) {
			System.out.println("出错了");
		} finally{
			System.out.println("finally中的代码执行了!");
		} 
		System.out.println("程序结束了!");
	}
}




