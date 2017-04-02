package day01;
/**
 * 文档注释仅在3个地方使用:
 * 类，常量，方法上使用。
 * 文档注释会通过javadoc命令进行解析，生成
 * 一个针对当前类的API文档。
 * 
 * 在类上声明，通常用来说明当前类的作用。
 * @author Administrator
 * @version 1.0,2016-02-25
 * @see java.lang.String
 * @since JDK1.0
 */
public class DocDemo {
	/**
	 * 该常量是作为sayHello中的问候语
	 */
	public static final String INFO = "你好!";
	
	/**
	 * 当前方法是将给定的用户添加一个问候语
	 * @param name 给定的用户的名字
	 * @return 带有问候语的字符串
	 */
	public static String sayHello(String name){
		return INFO + name;
	}
}






