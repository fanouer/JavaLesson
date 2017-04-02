package org.tedu.cloudnote.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static String md5(String password){
		try{
			//利用Md5将内容加密处理
			MessageDigest md = 
				MessageDigest.getInstance("MD5");
			byte[] output = md.digest(
					password.getBytes());//加密处理
			//利用Base64将加密结果output转成字符串类型
			String str = 
				Base64.encodeBase64String(output);
			return str;
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("密码加密失败");
			throw new RuntimeException("密码加密失败");
		}
	}
	
	public static void main(String[] args){
		System.out.println(createId());
		System.out.println(md5("123456"));
		System.out.println(md5("123456asdfasdfadfasdadsasddas"));
	}
	
}
