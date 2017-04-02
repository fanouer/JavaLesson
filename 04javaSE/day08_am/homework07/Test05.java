package homework07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 作业5:
 * @author Administrator
 *
 */
public class Test05 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		saveList();
		List<Emp> list = readList();
		for(Emp e : list){
			System.out.println(e);
		}
	}
 	
	public static List<Emp> readList()throws IOException,ClassNotFoundException{
		FileInputStream fis
			= new FileInputStream("emplist.obj");
		ObjectInputStream ois
			= new ObjectInputStream(fis);
		List<Emp> list = (List<Emp>)ois.readObject();
		System.out.println("反序列化完毕!");
		ois.close();
		return list;
	}
	
	public static void saveList() throws IOException{
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp("张三",25,"男",5000));
		list.add(new Emp("李四",26,"女",6000));
		list.add(new Emp("王五",27,"男",7000));
		list.add(new Emp("赵六",28,"女",8000));
		
		FileOutputStream fos
			= new FileOutputStream("emplist.obj");
		
		ObjectOutputStream oos
			= new ObjectOutputStream(fos);
		
		oos.writeObject(list);
		System.out.println("序列化完毕!");
		oos.close();
	}
}






