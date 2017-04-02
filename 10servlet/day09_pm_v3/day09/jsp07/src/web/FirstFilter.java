package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter {

	//服务器关闭时自动调用该方法来销毁Filter
	@Override
	public void destroy() {
		System.out.println("Fisrt销毁");
	}

	@Override
	public void doFilter(
		ServletRequest request, 
		ServletResponse response,
		FilterChain chain) 
		throws IOException, ServletException {
		System.out.println("First前前前");
		
		//过滤器对请求有绝对的处置权，
		//当调用chain.doFilter()时请求继续，
		//当不调用该方法时请求结束。
		//一个请求可以有多个Filter进行过滤，
		//他们按照先后顺序依次调用，且任何
		//一个Filter拒绝了请求则后续的
		//Filter及Servlet将不会被调用。
		//这种调用关系像一个链条，因此
		//称其为过滤链(FilterChain)。
		chain.doFilter(request, response);
		
		System.out.println("First后后后");
	}

	//Filter的初始化方法，用来给这个Filter
	//预置一些数据，由服务器自动调用。
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("First初始化");
	}

}
