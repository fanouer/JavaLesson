package day05;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.io.File 
 * 该类用于描述文件系统中的一个文件或目录
 * 使用它可以:
 * 访问文件或目录的属性(名字，大小等)
 * 访问目录中的子项
 * 操作文件或目录(创建，删除)
 * 但是不能:
 * 访问文件内容
 * @author Administrator
 *
 */
public class FileDemo1 {
	public static void main(String[] args) {
		/*
		 * 使用相对目录:当前目录是项目根目录
		 */
		File file = new File(
			"."+File.separator+"demo.txt"
		);
		//获取文件名
		String name = file.getName();
		System.out.println("文件名:"+name);
		
		//文件大小(字节)
		long length = file.length();
		System.out.println("大小:"+length+"字节");
		
		//判断是否为文件
		boolean isFile = file.isFile();
		System.out.println("文件:"+isFile);
		
		//判断是否为目录(文件夹)
		boolean isDir = file.isDirectory();
		System.out.println("目录:"+isDir);
		//可读，可写，可运行
		file.canRead();
		file.canWrite();
		file.canExecute();
		
		boolean isHidden = file.isHidden();
		System.out.println("是否隐藏:"+isHidden);
		
		//最后修改时间
		long lastModified = file.lastModified();
		Date date = new Date(lastModified);
		SimpleDateFormat format
			= new SimpleDateFormat(
			  "yyyy年M月d日 HH:mm:ss"
			);
		System.out.println("最后修改日期:"+format.format(date));
	}
}









