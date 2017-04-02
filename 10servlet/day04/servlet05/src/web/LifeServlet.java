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
		System.out.println("创建Servlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("销毁Servlet");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("初始化Servlet");
		//在Tomcat启动时会调用此方法，
		//此时给context存入默认的流量。
		//即count=0
		ServletContext ctx = getServletContext();
		ctx.setAttribute("count", 0);
	}

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		System.out.println("调用Servlet");
	}
	
	
	
}










