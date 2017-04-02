package homework07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ҵ5:
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
		System.out.println("�����л����!");
		ois.close();
		return list;
	}
	
	public static void saveList() throws IOException{
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp("����",25,"��",5000));
		list.add(new Emp("����",26,"Ů",6000));
		list.add(new Emp("����",27,"��",7000));
		list.add(new Emp("����",28,"Ů",8000));
		
		FileOutputStream fos
			= new FileOutputStream("emplist.obj");
		
		ObjectOutputStream oos
			= new ObjectOutputStream(fos);
		
		oos.writeObject(list);
		System.out.println("���л����!");
		oos.close();
	}
}






