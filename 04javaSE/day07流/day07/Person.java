package day07;

import java.io.Serializable;
import java.util.List;

/**
 * �������ڲ��Զ������Ķ�д����ʹ��
 * ��ǰ����ϣ����ObjectOutputStream���л�����ô
 * ��ǰ����Ҫʵ��Serializable�ӿڣ����ҵ�ǰ����
 * �������л�������Ҳ����Ҫʵ�ָýӿڡ�
 * 
 * ͨ��ObjectOutputStream��writeObject����
 * ���Խ���ǰ��ʵ��ת��Ϊһ���ֽں���ͨ��
 * FileOutputStreamд���ļ�����������漰��
 * ����רҵ����:
 * �������л�:��һ������ת��Ϊһ���ֽڵĹ���
 * ���ݳ־û�:��һ���ֽ�д�뵽���������ñ���
 * 
 * ͨ��ObjectInputStream��readObject������
 * һ���ֽڶ�ȡ����ԭ�ض���Ĺ��̳�Ϊ:
 * �������л�
 * 
 * @author Administrator
 *
 */
public class Person implements Serializable{
	
	/**
	 * �汾��:
	 * ��һ����ʵ����Serializable�ӿں�Ӧ��
	 * ����һ������:serialVersionUID
	 * �ð汾�ŵ������Ǿ���ObjectInputStream��ȡ
	 * һ����ǰ�Ķ����Ƿ���Գɹ��Ĺؼ��㡣
	 * ����ǰ��û�ж���汾�ţ�ObjectOutputStream
	 * ����д����ǰ����ʱ���ݵ�ǰ��Ķ�������һ��
	 * �汾�ţ���ǰ������Զ���û�з����κθı�Ļ���
	 * �ð汾�Ų���䣬���������仯��
	 * ��OIS��ȡ����ʱ����Աȵ�ǰ��İ汾���Ƿ�
	 * һ�£���һ����ʹ�ü���ģʽ(��ԭ���д��ڵ�����)
	 * ����һ�£�ֱ���׳��쳣���汾�����ϡ�
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	/*
	 * transient�ؼ������ε���������:
	 * ���ö���ObjectOutputStreamд��ʱ��
	 * �ᱻ���ԡ�
	 */
	private transient List<String> otherInfo;
	public Person(){
		
	}
	public Person(String name, int age, String gender, List<String> otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.otherInfo = otherInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}
	public String toString(){
		return name+","+age+","+
	           gender+","+otherInfo;
	}
}








