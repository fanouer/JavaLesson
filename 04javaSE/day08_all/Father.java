package day08;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 测试子类重写父类含有throws的方法的
 * 注意事项
 * @author Administrator
 *
 */
public class Father {
	public void dosome()
			throws IOException,AWTException{
		
	}
}

class Son extends Father{
	//允许不再抛出任何异常
//	public void dosome(){	
//	}
	
	/**
	 * 仅抛出父类方法抛出的部分异常
	 */
//	public void dosome()throws IOException{	
//	}
	/**
	 * 允许抛出父类抛出的子类异常
	 */
//	public void dosome()throws FileNotFoundException{	
//		
//	}
	/**
	 * 不允许抛出额外异常
	 */
//	public void dosome()throws SQLException{
//		
//	}
	/**
	 * 不允许抛出父类抛出的父类异常
	 */
//	public void dosome()throws Exception{
//		
//	}
}






