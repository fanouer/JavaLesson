package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//从session中取值
		HttpSession sn = req.getSession();
		Object obj = sn.getAttribute("user");
		System.out.println(obj);
		//转发到JSP
		//当前：/jsp06/demo/view
		//目标：/jsp06/WEB-INF/view.jsp
		req.getRequestDispatcher(
			"../WEB-INF/view.jsp")
			.forward(req, res);
	}
	
}






