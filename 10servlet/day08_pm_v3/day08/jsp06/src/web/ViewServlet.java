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
		//��session��ȡֵ
		HttpSession sn = req.getSession();
		Object obj = sn.getAttribute("user");
		System.out.println(obj);
		//ת����JSP
		//��ǰ��/jsp06/demo/view
		//Ŀ�꣺/jsp06/WEB-INF/view.jsp
		req.getRequestDispatcher(
			"../WEB-INF/view.jsp")
			.forward(req, res);
	}
	
}






