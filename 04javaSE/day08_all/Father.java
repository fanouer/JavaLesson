package day08;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * ����������д���ຬ��throws�ķ�����
 * ע������
 * @author Administrator
 *
 */
public class Father {
	public void dosome()
			throws IOException,AWTException{
		
	}
}

class Son extends Father{
	//�������׳��κ��쳣
//	public void dosome(){	
//	}
	
	/**
	 * ���׳����෽���׳��Ĳ����쳣
	 */
//	public void dosome()throws IOException{	
//	}
	/**
	 * �����׳������׳��������쳣
	 */
//	public void dosome()throws FileNotFoundException{	
//		
//	}
	/**
	 * �������׳������쳣
	 */
//	public void dosome()throws SQLException{
//		
//	}
	/**
	 * �������׳������׳��ĸ����쳣
	 */
//	public void dosome()throws Exception{
//		
//	}
}






