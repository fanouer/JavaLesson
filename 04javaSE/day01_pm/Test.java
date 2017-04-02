package day01;
/**
 * 截取域名
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		String host = "http://www.oracle.com";
		//经过处理后，输出域名:oracle
		System.out.println(getName(host));		
		host = "www.baidu.com";
		//输出域名:baidu
		System.out.println(getName(host));		
		host = "www.tarena.com.cn";
		//输出域名:tarena
		System.out.println(getName(host));
	}
	
	public static String getName(String host){
		/*
		 * 获取第一个"."与第二个"."之间的字符串
		 */
		int start = host.indexOf(".")+1;
		int end = host.indexOf(".",start);
		return host.substring(start,end);
	}
}

