package org.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet{
	
	public void service(
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException,ServletException{
		
		//获取请求提交的用户名key=name
		request.setCharacterEncoding("utf-8");
		String name = 
			request.getParameter("name");
		System.out.println("==="+name);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//判断name是否可用
		response.setContentType(
			"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if("scott".equals(name) 
			|| "tiger".equals(name)){
			out.print("用户名已被占用");
		}else{
			out.print("用户名可用");
		}
		out.flush();
		out.close();
	}
	
}



