package day07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * java.io.ObjectOutputStream
 * 对象输出流，是一个高级流，作用是可以将给定的java
 * 对象转换为一组字节后写出。
 * @author Administrator
 *
 */
public class OOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream(
					"person.obj"
			);
		ObjectOutputStream oos
			= new ObjectOutputStream(fos);
		
		Person p = new Person();
		p.setName("苍老师");
		p.setAge(18);
		p.setGender("女");
		List<String> otherInfo
			= new ArrayList<String>();
		otherInfo.add("是一名演员");
		otherInfo.add("童颜");
		otherInfo.add("喜欢写大字");
		otherInfo.add("促进中日文化交流");
		p.setOtherInfo(otherInfo);
		/*
		 * void writeObject(Object o)
		 * 可以将给定的对象转换为一组字节后写出。
		 */
		oos.writeObject(p);
		
		System.out.println("写入完毕!");
		
		oos.close();
	}
}








