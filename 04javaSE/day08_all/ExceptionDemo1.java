package day08;
/**
 * 异常处理机制
 * @author Administrator
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try{
			String str = "aa";
			System.out.println("length:"+str.length());
			System.out.println("charAt:"+str.charAt(1));
			System.out.println("int:"+Integer.parseInt(str));
			
			/*
			 * 在try语句块中报错代码下面的代码都不会被
			 * 执行。
			 */
			System.out.println("!!!");
		}catch(NullPointerException e){
			//处理空指针异常的逻辑
			System.out.println("出现了空指针!");
			
		//可以定义多个catch,捕获不同的异常	
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("出现了下标越界!");
		/*
		 * 应该养成一个好习惯，在最后一个catch中
		 * 捕获Exception,这样至少不会因为未捕获的
		 * 异常而导致程序中断。
		 * 当捕获的异常间存在父子继承关系时，一定是
		 * 子类异常在上，父类异常在下。
		 * 
		 */
		}catch(Exception e){
			System.out.println("反正就是出了个错!");
		}
		
		System.out.println("程序结束了");
	}
}




