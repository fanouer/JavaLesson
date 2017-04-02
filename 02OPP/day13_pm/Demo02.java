package day13;

public class Demo02 {
	public static void main(String[] args) {
		/*
		 * 接口语法测试
		 * 接口不能创建对象
		 */
		//Award a = new Award();
		Nokia n = new Nokia();
		//接口可以定义变量，引用具体子类的实例
		Award a = n;
		
	}
}
