package day07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * �ַ���:���ַ�Ϊ��λ��д���ݵ���
 * Writer:�����ַ�������ĸ���
 * Reader:�����ַ��������ĸ���
 * �ַ����������б���룬�Ὣ�ֽڵ����ַ�ת��������
 * �ַ���ֻ�ʺ϶�д�ı����ݡ�
 * �ַ������Ǹ߼�����ֻ�Ƿ������Ƕ�д�ַ����ݡ�
 * 
 * OutputStreamWriter:���õ��ַ������
 * �ص�:���԰���ָ�����ַ������������ַ���ת��Ϊ
 *     �ֽں�д����
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
		
		osw.write("��ǰ���¹�,");
		osw.write("���ǵ���˪,");
		osw.write("��ͷ������,");
		osw.write("����������.");
		
		osw.close();
		
		
	}
}






