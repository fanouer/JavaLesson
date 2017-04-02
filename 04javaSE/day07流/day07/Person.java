package day07;

import java.io.Serializable;
import java.util.List;

/**
 * 该类用于测试对象流的读写对象使用
 * 当前类若希望被ObjectOutputStream序列化，那么
 * 当前类需要实现Serializable接口，并且当前类中
 * 参与序列化的属性也都需要实现该接口。
 * 
 * 通过ObjectOutputStream的writeObject方法
 * 可以将当前类实例转换为一组字节后在通过
 * FileOutputStream写入文件。这个过程涉及到
 * 两个专业名词:
 * 对象序列化:将一个对象转换为一组字节的过程
 * 数据持久化:将一组字节写入到磁盘做长久保存
 * 
 * 通过ObjectInputStream的readObject方法将
 * 一组字节读取并还原回对象的过程称为:
 * 对象反序列化
 * 
 * @author Administrator
 *
 */
public class Person implements Serializable{
	
	/**
	 * 版本号:
	 * 当一个类实现了Serializable接口后，应当
	 * 定义一个常量:serialVersionUID
	 * 该版本号的作用是决定ObjectInputStream读取
	 * 一个以前的对象是否可以成功的关键点。
	 * 若当前类没有定义版本号，ObjectOutputStream
	 * 会在写出当前对象时根据当前类的定义生成一个
	 * 版本号，当前类的属性定义没有发生任何改变的话，
	 * 该版本号不会变，否则会产生变化。
	 * 当OIS读取对象时，会对比当前类的版本号是否
	 * 一致，若一致则使用兼容模式(还原所有存在的属性)
	 * 若不一致，直接抛出异常，版本不符合。
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	/*
	 * transient关键字修饰的属性作用:
	 * 当该对象被ObjectOutputStream写出时，
	 * 会被忽略。
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








