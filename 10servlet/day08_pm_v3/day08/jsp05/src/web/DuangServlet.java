package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DuangServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		Cookie c = 
			new Cookie("company","Tarena");
		//设置cookie的有效路径
		c.setPath(req.getContextPath());
		res.addCookie(c);
	}

	
	
}






