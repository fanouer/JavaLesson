package demo;

import java.lang.reflect.Field;

public class Utils {
	/**
	 * ��ʾһ������ȫ��������Ϣ
	 * @param className ����
	 * @throws Exception ��������ʱ�����쳣
	 */
	public static void showFileds(
			String className)
		throws Exception {
		//��̬������(����Ϣ��������)
		Class cls = Class.forName(className);
		//��̬��ȡȫ��������Ϣ
		Field[] fields = 
			cls.getDeclaredFields();
		//for�����������飬��ʾȫ��������Ϣ
		for(Field f:fields){
			System.out.print(f.getType()+" ");
			System.out.println(f.getName());
		}
	}
}



