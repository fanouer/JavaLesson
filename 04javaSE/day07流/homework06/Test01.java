package homework06;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {
	public static void main(String[] args) throws IOException {
//		List<Emp> list = new ArrayList<Emp>();
//		list.add(new Emp("����",25,"��",5000));
//		list.add(new Emp("����",26,"Ů",6000));
//		list.add(new Emp("����",27,"��",7000));
//		list.add(new Emp("����",28,"Ů",8000));
//		list.add(new Emp("jackson",29,"��",9000.1));
//		
//		saveList(list);
		
		List<Emp> list1 = readList();
		for(Emp e : list1){
			System.out.println(e);
		}
		
	}
	/**
	 * �������ļ����е�����Ա�������ļ�emplist.dat
	 * @param list
	 * @throws IOException 
	 */
	public static void saveList(List<Emp> list) throws IOException{
		RandomAccessFile raf
			= new RandomAccessFile("emplist.dat","rw");
		/*
		 * �û�������32�ֽ�
		 * �Ա𶨳�2�ֽ�
		 */	
		for(Emp e : list){
			//д�û���
			String name = e.getName();
			byte[] data = name.getBytes("GBK");
			data = Arrays.copyOf(data, 32);
			raf.write(data);
			//д����
			raf.writeInt(e.getAge());
			//д�Ա�
			raf.write(
			  e.getGender().getBytes("GBK")
			);
			//д����
			raf.writeDouble(e.getSalary());
			
		}
		System.out.println("�������!");
		raf.close();
	}
	/**
	 * ��ȡemplist.dat�ļ���������Ա����ȡ����
	 * �����뼯�Ϻ󷵻ء�
	 * @return
	 * @throws IOException 
	 */
	public static List<Emp> readList() throws IOException{
		List<Emp> list = new ArrayList<Emp>();
		File file = new File("emplist.dat");
		RandomAccessFile raf
			= new RandomAccessFile(
				file,"r"	
			);
		//��ѭ��
		while(true){
			/*
			 * ���ж��ļ����Ƿ�����Ϣ�ɶ�
			 */
			long pos = raf.getFilePointer();
			if(pos>=file.length()){
				break;
			}			
			//��ȡ�û���
			byte[] data = new byte[32];
			raf.read(data);
			String name = new String(data,"GBK").trim();
			
			//��ȡ����
			int age = raf.readInt();
			
			//��ȡ�Ա�
			byte[] data1 = new byte[2];
			raf.read(data1);
			String gender = new String(data1,"GBK");
			
			//��ȡ����
			double salary = raf.readDouble();
			
			Emp e = new Emp(name,age,gender,salary);
			list.add(e);
		}
		System.out.println("��ȡ���!");
		raf.close();
		return list;
	}
}




