package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �����ļ�
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
			= new RandomAccessFile("music.mp3","r");
		
		RandomAccessFile desc
			= new RandomAccessFile("music_copy.mp3","rw");
		
		int d = -1;
		while(  (d = src.read()) != -1 ){
			desc.write(d);
		}
		System.out.println("�������!");
		src.close();
		desc.close();
	}
}





