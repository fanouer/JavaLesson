package day07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 字符流:以字符为单位读写数据的流
 * Writer:所有字符输出流的父类
 * Reader:所有字符输入流的父类
 * 字符流天生带有编解码，会将字节当做字符转换。所以
 * 字符流只适合读写文本数据。
 * 字符流都是高级流。只是方便我们读写字符数据。
 * 
 * OutputStreamWriter:常用的字符输出流
 * 特点:可以按照指定的字符集将给定的字符串转换为
 *     字节后写出。
 * 
 * @author Administrator
 *
 */
public class OSWDemo {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos
			= new FileOutputStream("osw.txt");
		
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"UTF-8");
		
		osw.write("窗前明月光,");
		osw.write("疑是地上霜,");
		osw.write("举头望明月,");
		osw.write("粒粒皆辛苦.");
		
		osw.close();
		
		
	}
}






