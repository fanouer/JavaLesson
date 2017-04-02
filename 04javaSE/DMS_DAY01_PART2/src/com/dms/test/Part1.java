package com.dms.test;

import java.io.File;
import java.io.PrintWriter;

/**
 * 该测试用来测试IOUtil类中的方法:
 * public static void saveLong(long lon,File file) throws Exception
 * 注:该方法在项目中用来保存每次解析wtmpx文件后的位置
 */
public class Part1 {
	/**
	 * 将指定的long值以字符串的形式写入到
	 * 给定文件的第一行
	 * 提示:使用PrintWriter
	 * @param lon 要写入的long值
	 * @param file 要写入的文件
	 * @throws Exception 写入过程出错应抛出异常给调用者
	 */
	public static void saveLong(long lon,File file) throws Exception{
		
	}
	
	public static void main(String[] args) {
		try {
			/*
			 * 执行后文件中应当存在一行字符串，内容为:3720
			 */
			File file = new File("src/com/dms/test/test_last-position.txt");
			saveLong(3720,file);		
			/*
			 * 执行完毕后，当前目录下应当有一个名为test_last-position.txt的
			 * 文件，该文件中第一行内容则是:3720
			 */
			System.out.println("执行完毕!");
		} catch (Exception e) {
			System.out.println("执行出错!");
			e.printStackTrace();
		}
	}
}
