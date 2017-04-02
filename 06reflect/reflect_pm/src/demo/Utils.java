package demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Utils {
	
	/**
	 * ����ĳ�����ĳ������
	 * @param obj ĳ������
	 * @param method ĳ������
	 * @param paramTypes ���������б�
	 * @param params �����б�
	 * @return �������
	 * 
	 *  Koo koo = new Koo();
	 *  Object val=execute(koo, "sayHello", 
	 *  	new Class[]{String.class, String.class},
	 *  	new Object[]{"Tom", "Jerry"});
	 */
	public static Object execute(
		Object obj, 
		String method, 
		Class[] paramTypes,
		Object[] params)
		throws Exception {
		Class cls = obj.getClass();
		//�ҵ�������Ϣ
		Method m = cls.getDeclaredMethod(
			method, paramTypes);
		//���÷���, �ڶ�����ִ�з�����params���ݵĲ���
		// invoke ����
		Object val = m.invoke(obj, params);
		return val;
	}
	
	
	/**
	 * ����ĳ�����ĳ������
	 * @param obj ĳ����
	 * @param fieldName ĳ�����Ե���
	 * @return ���Ե�ֵ
	 * �ٸ����ӣ�
	 *   Koo koo = new Koo(2,4);
	 *                     a b
	 *   Object val = get(koo, "a");//2
	 *   koo.a;
	 */
	public static Object get(Object obj,
			String fieldName)
		throws Exception{
		//�ҵ�Class Object.getClass()
		Class cls = obj.getClass();
		//�ҵ�������ϢField
		Field field = 
			cls.getDeclaredField(fieldName);
		//����������Ϣ��Field��get������ȡ����ֵ
		Object val=field.get(obj);//��ȡ���������
		return val;
	}
	
	
	/**
	 * ��̬ ���á�ĳ���ࡱ�ġ�ĳ������������������
	 * @param className ĳ������
	 * @param paramTypes ĳ���������Ĳ��������б�
	 * @param params ���ù��������ݵĲ����б�
	 * @return һ������
	 * ���磺
	 * create("java.util.ArrayList",
	 * 	new Class[]{int.class},
	 *  new Object[]{200});
	 *  �൱��  new ArrayList(200);
	 */
	public static Object create(
		String className,
		Class[] paramTypes,
		Object[] params)
		throws Exception{
		//��̬������
		Class cls=Class.forName(className);
		//���ݲ��������б��ҵ���������Ϣ��
		Constructor constructor =
			cls.getDeclaredConstructor(
			paramTypes);
		//constructor��������Ϣ���ṩִ�й������ķ���
		//newInstance��ִ����������������ṩ
		// �����б�����������������б�ƥ�䣡
		Object obj = 
		  constructor.newInstance(params);
		return obj;
	}
	
	
	/**
	 * ��ʾһ�����ȫ����������Ϣ
	 */
	public static void showInit(
			String className)
		throws Exception {
		//Constructor: ������
		Class cls = Class.forName(className);
		Constructor[] constructors=
			cls.getDeclaredConstructors();
		for(Constructor c:constructors){
			System.out.print(c.getName());
			System.out.println(
				Arrays.toString(
				c.getParameterTypes()));
		}
	}
	
	
	/**
	 * ��ʾһ�����ȫ��������Ϣ
	 * ��������һ����̬����
	 */
	public static void showMethods(
		String className)
		throws Exception {
		Class cls = Class.forName(className);
		/*
		 * ����cls����Ϣ��ȫ���ķ�����Ϣ
		 * Declared:����     Method������
		 * Parameter������  Type:��������
		 */
		Method[] methods =
			cls.getDeclaredMethods();
		for(Method m:methods){
			System.out.print(
				m.getReturnType()+" ");
			System.out.print(m.getName());
			System.out.println(
				Arrays.toString(
				m.getParameterTypes()));
		}
	}
	
	
	
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



