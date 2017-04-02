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
			//�����ļ���������ַ���
			String str = "";
			//�����ȡ��ÿһ������
			String line = null;
			while((line = br.readLine())!=null){
				str+=line;
			}
			//��׮
			System.out.println(str);
			
			//д�ļ�����
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
		System.out.println("���!");
	}
}
