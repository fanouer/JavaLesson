package container.other;

public class MessageBean {

	public MessageBean() {
		System.out.println(
				"MessageBean的无参构造器");
	}
	
	/**
	 * 初始化方法
	 *    方法名可以自定义
	 */
	public void init(){
		System.out.println("MessageBean的" +
				"init方法");
	}
	
	/**
	 * 销毁方法
	 */
	public void destroy(){
		System.out.println("MessageBean的" +
		"destroy方法");
	}
	
	
}
