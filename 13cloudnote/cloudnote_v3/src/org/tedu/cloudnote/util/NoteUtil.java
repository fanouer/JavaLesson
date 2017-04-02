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
			//����Md5�����ݼ��ܴ���
			MessageDigest md = 
				MessageDigest.getInstance("MD5");
			byte[] output = md.digest(
					password.getBytes());//���ܴ���
			//����Base64�����ܽ��outputת���ַ�������
			String str = 
				Base64.encodeBase64String(output);
			return str;
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("�������ʧ��");
			throw new RuntimeException("�������ʧ��");
		}
	}
	
	public static void main(String[] args){
		System.out.println(createId());
		System.out.println(md5("123456"));
		System.out.println(md5("123456asdfasdfadfasdadsasddas"));
	}
	
}
