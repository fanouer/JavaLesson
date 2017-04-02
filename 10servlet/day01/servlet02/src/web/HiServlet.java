package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//1.读取请求数据
		//1.1请求行
		System.out.println(
			"协议类型:"+req.getProtocol());
		System.out.println(
			"请求方式:"+req.getMethod());
		System.out.println(
			"Servlet路径:"+req.getServletPath());
		//1.2消息头(key-value)
		//hearderNames是所有的key；
		//Enumeration是这组key的迭代器；
		//它是比Iterator更古老的迭代器。
		Enumeration<String> e = 
			req.getHeaderNames();
		while(e.hasMoreElements()) {
			String key = e.nextElement();
			String value = req.getHeader(key);
			System.out.println(
				key + ":" + value);
		}
		//1.3实体内容
		//由于本案例没有给Servlet传数据，
		//因此实体内容是空的，将来再讲。
		
		//2.写响应数据
		//2.1状态行
		//该数据由Tomcat自动写入
		//2.2消息头
		res.setContentType("text/html");
		PrintWriter w = res.getWriter();
		
		Date date = new Date();
		SimpleDateFormat sdf = 
			new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(date);
		
		//2.3实体内容
		w.println("<h1>");
		w.println(now);
		w.println("</h1>");
		
		w.close();
	}

	
	
}






