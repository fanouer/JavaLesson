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
//		list.add(new Emp("张三",25,"男",5000));
//		list.add(new Emp("李四",26,"女",6000));
//		list.add(new Emp("王五",27,"男",7000));
//		list.add(new Emp("赵六",28,"女",8000));
//		list.add(new Emp("jackson",29,"男",9000.1));
//		
//		saveList(list);
		
		List<Emp> list1 = readList();
		for(Emp e : list1){
			System.out.println(e);
		}
		
	}
	/**
	 * 将给定的集合中的所有员工存入文件emplist.dat
	 * @param list
	 * @throws IOException 
	 */
	public static void saveList(List<Emp> list) throws IOException{
		RandomAccessFile raf
			= new RandomAccessFile("emplist.dat","rw");
		/*
		 * 用户名定长32字节
		 * 性别定长2字节
		 */	
		for(Emp e : list){
			//写用户名
			String name = e.getName();
			byte[] data = name.getBytes("GBK");
			data = Arrays.copyOf(data, 32);
			raf.write(data);
			//写年龄
			raf.writeInt(e.getAge());
			//写性别
			raf.write(
			  e.getGender().getBytes("GBK")
			);
			//写工资
			raf.writeDouble(e.getSalary());
			
		}
		System.out.println("保存完毕!");
		raf.close();
	}
	/**
	 * 读取emplist.dat文件，将所有员工读取出来
	 * 并存入集合后返回。
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
		//死循环
		while(true){
			/*
			 * 先判断文件中是否还有信息可读
			 */
			long pos = raf.getFilePointer();
			if(pos>=file.length()){
				break;
			}			
			//读取用户名
			byte[] data = new byte[32];
			raf.read(data);
			String name = new String(data,"GBK").trim();
			
			//读取年龄
			int age = raf.readInt();
			
			//读取性别
			byte[] data1 = new byte[2];
			raf.read(data1);
			String gender = new String(data1,"GBK");
			
			//读取工资
			double salary = raf.readDouble();
			
			Emp e = new Emp(name,age,gender,salary);
			list.add(e);
		}
		System.out.println("读取完毕!");
		raf.close();
		return list;
	}
}




