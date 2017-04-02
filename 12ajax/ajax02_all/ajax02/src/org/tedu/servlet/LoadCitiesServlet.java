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
		
		City c1 = new City(101,"北京");
		City c2 = new City(102,"上海");
		City c3 = new City(103,"广州");
		City c4 = new City(104,"深圳");
		List<City> list = new ArrayList<City>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		//将list数据转成JSON字符串
		JSONArray obj = JSONArray.fromObject(list);
		String msg = obj.toString();
		//输出
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(msg);
		out.flush();
		out.close();
	}
	
}
