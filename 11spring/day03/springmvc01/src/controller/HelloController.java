package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Controller(二级控制器): 负责处理请求。
 * 1. 实现Controller接口
 * 2. 在handleRequest方法里面完成
 *   请求的处理。
 */
public class HelloController 
implements Controller{

	public ModelAndView handleRequest(
			HttpServletRequest req,
			HttpServletResponse res) 
	throws Exception {
		System.out.println("HelloController的" +
				"handleRequest方法");
		/*
		 * ModelAndView有两个构造器:
		 * ModelAndView(String viewName)
		 * 注：
		 * 	viewName是视图名(逻辑名称)，需要由
		 *  ViewResolver去解析成真正的视图
		 *  对象(比如，某个JSP)。
		 * ModelAndView(String viewName, Map data)
		 * 注：
		 * 	data是处理结果。
		 */
		return new ModelAndView("hello");
	}
	
}





