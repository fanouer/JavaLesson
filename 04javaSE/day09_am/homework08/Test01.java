package homework08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Test01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		PrintWriter pw =  null;
		try {
			br = new BufferedReader(
				new InputStreamReader(
					new FileInputStream(
						"pw.txt"	
					)	
				)	
			);
			//保存文件里的所有字符串
			String str = "";
			//保存读取的每一行内容
			String line = null;
			while((line = br.readLine())!=null){
				str+=line;
			}
			//打桩
			System.out.println(str);
			
			//写文件操作
			pw = new PrintWriter(
				new FileOutputStream(
					"pw.txt",true
				)	
			);
			pw.println(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(pw != null){
				pw.close();
			}
		}
		System.out.println("完毕!");
	}
}
