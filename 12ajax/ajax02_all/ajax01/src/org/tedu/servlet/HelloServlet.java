package org.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	public void service(
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException,ServletException{
		System.out.println("==执行HelloServlet==");
		//输出一个hello消息
		response.setContentType(
			"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("Hello Ajax");
		out.flush();
		out.close();
	}
	
}
