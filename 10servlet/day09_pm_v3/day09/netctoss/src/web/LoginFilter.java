package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
	
	String[] paths;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(
		ServletRequest request, 
		ServletResponse response,
		FilterChain chain) throws IOException, ServletException {
		//Tomcat在调用Filter传入的就是
		//HttpServletRequest和HttpServletResponse
		HttpServletRequest req = 
			(HttpServletRequest) request;
		HttpServletResponse res = 
			(HttpServletResponse) response;
		//有3个请求不需要检查，放行
//		String[] paths = new String[]{
//			"/toLogin.do",
//			"/login.do",
//			"/createImg.do"
//		};
		String path = req.getServletPath();
		for(String p : paths) {
			if(p.equals(path)) {
				chain.doFilter(req, res);
				return;
			}
		}
		//其他的请求都检查是否登录
		String adminCode = (String)
			req.getSession().getAttribute("adminCode");
		if(adminCode == null) {
			//未登录，重定向到登录页
			res.sendRedirect(
				req.getContextPath() + "/toLogin.do");
		} else {
			//已登录，放行
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		String epath = 
			cfg.getInitParameter("excludePath");
		paths = epath.split(",");
	}

}





