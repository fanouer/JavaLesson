package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Second销毁");
	}

	@Override
	public void doFilter(
		ServletRequest request, 
		ServletResponse response,
		FilterChain chain) throws IOException, ServletException {
		System.out.println("Second前前前");
		chain.doFilter(request, response);
		System.out.println("Second后后后");
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		System.out.println("Second初始化");
		System.out.println(
			cfg.getInitParameter("city"));
	}

}





