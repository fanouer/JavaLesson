package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet {

	public LifeServlet() {
		System.out.println("����Servlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("����Servlet");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("��ʼ��Servlet");
		//��Tomcat����ʱ����ô˷�����
		//��ʱ��context����Ĭ�ϵ�������
		//��count=0
		ServletContext ctx = getServletContext();
		ctx.setAttribute("count", 0);
	}

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		System.out.println("����Servlet");
	}
	
	
	
}










