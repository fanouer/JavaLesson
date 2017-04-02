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
		System.out.println("Second����");
	}

	@Override
	public void doFilter(
		ServletRequest request, 
		ServletResponse response,
		FilterChain chain) throws IOException, ServletException {
		System.out.println("Secondǰǰǰ");
		chain.doFilter(request, response);
		System.out.println("Second����");
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		System.out.println("Second��ʼ��");
		System.out.println(
			cfg.getInitParameter("city"));
	}

}





