package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AbcServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//项目部署名
		System.out.println(req.getContextPath());
		//Servlet访问路径
		System.out.println(req.getServletPath());
		//URI
		System.out.println(req.getRequestURI());
		//URL
		System.out.println(req.getRequestURL());
	}

	
	
}






