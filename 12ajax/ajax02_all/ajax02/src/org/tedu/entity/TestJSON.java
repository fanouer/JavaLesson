package org.tedu.entity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestJSON {
	//��һ��Personת��JSON�ַ���
	@Test
	public void test1(){
		Person  p = new Person(101,"tom");
		JSONObject obj = JSONObject.fromObject(p);
		String str = obj.toString();
		System.out.println(str);
	}
	
	@Test//��һ������ת��JSON�ַ���
	public void test2(){
		Person  p = new Person(101,"tom");
		Person  p1 = new Person(102,"rose");
		List<Person> list = new ArrayList<Person>();
		list.add(p);
		list.add(p1);
		//ת��
		JSONArray obj = JSONArray.fromObject(list);
		String str = obj.toString();
		System.out.println(str);
	}
	
}




