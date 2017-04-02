package day07;

import java.io.UnsupportedEncodingException;

public class bin {

	public static void main(String[] args) throws UnsupportedEncodingException {
		int num =15;//15->1111
		//System.out.println(num);//"15"
		
	//11000101
	//128*1+64*1+32*0+16*0+8*0+4*1+2*0+1*1=197
	//	System.out.println
	//	(Integer.toBinaryString(197));
		
	//补码最大值
	//int max=Integer.MAX_VALUE;
	//System.out.println(
	//		Integer.toBinaryString(max));
	
	//int min;
	//min=max+1;
	//System.out.println(
	//		Integer.toBinaryString(Integer.MIN_VALUE));
	//System.out.println(
	//		Integer.toBinaryString(min));
	
	//int a=-1;
	//System.out.println(
	//		Integer.toBinaryString(a));
	//a 11111111111111111111111111111111
	//b 1111111111111111111111111111111
	//c 10000000000000000000000000000000
	//d +1111111111111111111111111111111
	
	int n=5;
	int max=Integer.MAX_VALUE;
	//System.out.println(n+(max+1)*2);
	
	//System.out.println(~3+1);	//-3
	//~00000000000000000000000000000011
	//+11111111111111111111111111111100
	// 00000000000000000000000000000001
	// 11111111111111111111111111111101
	// 11111111111111111111111111111101
	//System.out.println(Integer.toBinaryString(-3));
	//System.out.println(~100);	//-101
	//System.out.println(Integer.toHexString(202));
	//System.out.println(
	//		Integer.toBinaryString(100));
	//System.out.println(
	//		Integer.toBinaryString(100<<1));
	//System.out.println(
	//		Integer.toBinaryString(100<<2));
	//System.out.println(
	//		Integer.toBinaryString(100<<8));
	
	/*System.out.println(
			Integer.toBinaryString(100));
	System.out.println(
			Integer.toBinaryString(100>>1));
	System.out.println(
			Integer.toBinaryString(100>>2));
	System.out.println(
			Integer.toBinaryString(100>>8));
	*/
	/*
	int sum;
	int a=0x00000001;	//00000001
	int b=0x00000011;	//00010001
	sum=a|b;			//00010001 10001
	System.out.println(
			Integer.toBinaryString(sum));
	*/
	//System.out.println(100);	//100
	//System.out.println(100<<1);	//"200"
	//System.out.println(100<<2);	//400
	
	//System.out.println(
	//		Integer.toBinaryString(49));
	/*
	int R=255;
	int G=99;
	int B=49;
	int rgb;
	rgb=(R<<16)|(G<<8)|B;	//ff6331
	System.out.println(
			Integer.toHexString(rgb));
	*/
	String str="你好";
	byte[] bytes=str.getBytes("utf-8");
	String str1=new String(bytes,"utf-8");
	String str2=new String(bytes,"gbk");
	System.out.println(str1);
	System.out.println(str2);
	
	
	}
	
	
}
