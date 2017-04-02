package com.dms.test;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 该测试用来测试IOUtil类中的方法:
 * public static void saveCollection(Collection c,File file) throws Exception
 */
public class Part3 {
	/**
	 * 将集合中每个元素的toString方法返回的字符串
	 * 按行写入到指定文件中。
	 * @param c
	 * @param file
	 * @throws Exception 
	 */
	public static void saveCollection(Collection c,File file) throws Exception{
		
	}
	
	public static void main(String[] args) {
		try {
			List<String> list = new ArrayList<String>();
			list.add("lidz,441232,7,1375334515,192.168.1.61");
			list.add("baizt,16321,7,1376331705,192.168.1.78");
			list.add("tongxy,15332,7,1376446317,192.168.1.65");
			list.add("moxb,23123,7,1377441617,192.168.1.69");
			list.add("huangr,12348,7,1377537895,192.168.1.38");
			list.add("huangr,12348,8,1377541495,192.168.1.38");
			File file = new File("src/com/dms/test/log.txt");
			saveCollection(list, file);
			/*
			 * 执行完毕后，当前目录下应当存在一个名为log.txt
			 * 的文件，而该文件中应当有6行记录，每行就是这里list
			 * 集合中每个元素对应的字符串
			 */
			System.out.println("保存完毕!");
		} catch (Exception e) {
			System.out.println("保存失败!");
			e.printStackTrace();
		}
	}
}
