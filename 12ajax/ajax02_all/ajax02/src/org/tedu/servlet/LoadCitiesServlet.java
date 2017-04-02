package org.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.tedu.entity.City;

public class LoadCitiesServlet extends HttpServlet{
	
	public void service(
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException,ServletException{
		
		City c1 = new City(101,"����");
		City c2 = new City(102,"�Ϻ�");
		City c3 = new City(103,"����");
		City c4 = new City(104,"����");
		List<City> list = new ArrayList<City>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		//��list����ת��JSON�ַ���
		JSONArray obj = JSONArray.fromObject(list);
		String msg = obj.toString();
		//���
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(msg);
		out.flush();
		out.close();
	}
	
}
