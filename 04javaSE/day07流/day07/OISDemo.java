package day07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * java.io.ObjectInputStream
 * 该类是一个高级流，用于读取一个对象。
 * 需要注意的是，使用该流读取的字节，应当是由
 * ObjectOutputStream将对象转换的字节才可以。
 * 否则会抛出异常:ClassNotFoundException
 * @author Administrator
 *
 */
public class OISDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis
			= new FileInputStream(
				"person.obj"
			);
		
		ObjectInputStream ois
			= new ObjectInputStream(fis);
		
		Person p = (Person)ois.readObject();
		
		System.out.println(p);
		
		ois.close();
	}
}





