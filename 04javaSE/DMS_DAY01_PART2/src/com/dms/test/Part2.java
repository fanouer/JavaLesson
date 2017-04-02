package com.dms.test;

import java.io.File;

/**
 * 该测试用来测试IOUtil类中的方法:
 * public static long readLong(File file) throws Exception
 * 注:该方法在项目中用来保存每次解析wtmpx文件后的位置
 */
public class Part2 {
	/**
	 * 从给定文件中读取第一行字符串，然后将其
	 * 转换为一个long值后返回
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	public static long readLong(File file) throws Exception{
		return -1;
	}
	
	public static void main(String[] args) {
		try {
			File file = new File("src/com/dms/test/last-position.txt");
			long lon = readLong(file);		
			/*
			 * 输出结果,应当为:
			 * lastPosition:3720
			 */
			System.out.println("lastPosition:"+lon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
