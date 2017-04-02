package org.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadCitiesServlet 
	extends HttpServlet{
	
	public void service(
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException,ServletException{
		System.out.println("---LoadCitiesServlet---");
		response.setContentType(
			"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String str = "1:北京;2:上海;3:天津";
		out.print(str);
		out.flush();
		out.close();
	}
	
}
