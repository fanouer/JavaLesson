package homework06;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp("张三",25,"男",5000));
		list.add(new Emp("李四",26,"女",6000));
		list.add(new Emp("王五",27,"男",7000));
		list.add(new Emp("赵六",28,"女",8000));
		list.add(new Emp("jack",29,"男",9000.1));
		
		saveList(list);
		
		List<Emp> list1 = readList();
		
	}
	/**
	 * 将给定的集合中的所有员工存入文件emplist.dat
	 * @param list
	 */
	public static void saveList(List<Emp> list){
		
	}
	/**
	 * 读取emplist.dat文件，将所有员工读取出来
	 * 并存入集合后返回。
	 * @return
	 */
	public static List<Emp> readList(){
		List<Emp> list = new ArrayList<Emp>();
		
		return list;
	}
}




