package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements 
HandlerInterceptor{

	/**
	 * 整个处理流程结束之后
		执行。
		arg2:  二级控制器的方法对象。
		e: 二级控制器的方法抛出的异常。
	 */
	public void afterCompletion(
			HttpServletRequest req,
			HttpServletResponse res, 
			Object arg2, Exception e)
			throws Exception {
		System.out.println(
		"SomeInterceptor的afterCompletion方法");
	}

	/**
	 * 二级控制器的方法已经执行
	完毕，在返回ModelAndView对象给
	前端控制器之前先执行。可以在该方法里面，
	修改ModelAndView中的数据。
	arg2:  二级控制器的方法对象。
	 */
	public void postHandle(
			HttpServletRequest req, 
			HttpServletResponse res,
			Object arg2, ModelAndView mav) 
	throws Exception {
		System.out.println(
			"SomeInterceptor的postHandle方法");
	
	}

	/**
	 * 前端控制器调用二级控制器
	     之前先执行。如果该方法返回值为true,
	     表示继续向后调用；如果返回值为false,
	     中断处理。
	   arg2:  二级控制器的方法对象。
	 */
	public boolean preHandle(
			HttpServletRequest req, 
			HttpServletResponse res,
			Object arg2) throws Exception {
		System.out.println(
			"SomeInterceptor的preHandle方法");
		return true;
	}

}
