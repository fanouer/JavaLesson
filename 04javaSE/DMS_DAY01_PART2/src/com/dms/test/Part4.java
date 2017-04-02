package com.dms.test;



import java.io.RandomAccessFile;

/**
 * 该测试用来测试IOUtil类中的方法:
 * public static String readString(RandomAccessFile raf,int length) throws Exception{
 */
public class Part4 {
	/**
	 * 从给定的RandomAccessFile当前位置开始连续
	 * 读取length个字节，并转换为字符串后返回
	 * 转换字符串时使用的字符集为:ISO8859-1
	 * @param raf
	 * @param length
	 * @return
	 * @throws Exception 
	 */
	public static String readString(RandomAccessFile raf,int length) throws Exception{
		return "";
	}
	
	public static void main(String[] args) {
		try {
			/*
			 * 该测试文件中32个字节表示的字符串为lidz,剩余
			 * 字符全部为空格。
			 */
			RandomAccessFile raf = new RandomAccessFile("src/com/dms/test/test.dat","r");
			String str = readString(raf,32);
			/*
			 * 应当输出:
			 * 内容:lidz
			 */
			System.out.println("内容:"+str.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
