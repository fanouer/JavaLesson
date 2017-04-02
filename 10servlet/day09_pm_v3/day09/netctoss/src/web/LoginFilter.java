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
		//Tomcat�ڵ���Filter����ľ���
		//HttpServletRequest��HttpServletResponse
		HttpServletRequest req = 
			(HttpServletRequest) request;
		HttpServletResponse res = 
			(HttpServletResponse) response;
		//��3��������Ҫ��飬����
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
		//���������󶼼���Ƿ��¼
		String adminCode = (String)
			req.getSession().getAttribute("adminCode");
		if(adminCode == null) {
			//δ��¼���ض��򵽵�¼ҳ
			res.sendRedirect(
				req.getContextPath() + "/toLogin.do");
		} else {
			//�ѵ�¼������
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





