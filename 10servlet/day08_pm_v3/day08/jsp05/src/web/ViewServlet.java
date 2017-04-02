package web;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//获取Cookie
		Cookie[] cs = req.getCookies();
		if(cs != null) {
			for(Cookie c : cs) {
				System.out.println(
					c.getName() + ":" + 
					URLDecoder.decode(
						c.getValue(),"utf-8"));
			}
		}
		//转发到JSP
		//当前：/jsp05/demo/view
		//目标：/jsp05/WEB-INF/view.jsp
		req.getRequestDispatcher(
			"../WEB-INF/view.jsp")
			.forward(req, res);
	}

	
	
}







