package homework06;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp("����",25,"��",5000));
		list.add(new Emp("����",26,"Ů",6000));
		list.add(new Emp("����",27,"��",7000));
		list.add(new Emp("����",28,"Ů",8000));
		list.add(new Emp("jack",29,"��",9000.1));
		
		saveList(list);
		
		List<Emp> list1 = readList();
		
	}
	/**
	 * �������ļ����е�����Ա�������ļ�emplist.dat
	 * @param list
	 */
	public static void saveList(List<Emp> list){
		
	}
	/**
	 * ��ȡemplist.dat�ļ���������Ա����ȡ����
	 * �����뼯�Ϻ󷵻ء�
	 * @return
	 */
	public static List<Emp> readList(){
		List<Emp> list = new ArrayList<Emp>();
		
		return list;
	}
}




