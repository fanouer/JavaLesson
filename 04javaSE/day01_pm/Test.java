package day01;
/**
 * ��ȡ����
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		String host = "http://www.oracle.com";
		//����������������:oracle
		System.out.println(getName(host));		
		host = "www.baidu.com";
		//�������:baidu
		System.out.println(getName(host));		
		host = "www.tarena.com.cn";
		//�������:tarena
		System.out.println(getName(host));
	}
	
	public static String getName(String host){
		/*
		 * ��ȡ��һ��"."��ڶ���"."֮����ַ���
		 */
		int start = host.indexOf(".")+1;
		int end = host.indexOf(".",start);
		return host.substring(start,end);
	}
}

