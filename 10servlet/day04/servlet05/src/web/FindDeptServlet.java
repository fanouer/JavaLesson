package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindDeptServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//使用context读取web.xml中的参数
		ServletContext ctx = getServletContext();
		System.out.println(
			ctx.getInitParameter("pageSize"));
		//统计流量(count++)
		Object obj = ctx.getAttribute("count");
		int count = new Integer(obj.toString())+1;
		ctx.setAttribute("count", count);
		System.out.println("总流量:"+count);
	}

	
	
}



