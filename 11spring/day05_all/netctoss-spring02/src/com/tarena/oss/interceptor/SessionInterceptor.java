package com.tarena.oss.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ����session��֤��������
 *
 */
public class SessionInterceptor 
implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	public boolean preHandle(
			HttpServletRequest req,
			HttpServletResponse res,
			Object arg2) throws Exception {
		System.out.println(
			"SessionInterceptor��preHandle����");
		HttpSession session = 
			req.getSession();
		Object obj = 
			session.getAttribute("admin");
		if(obj == null){
			//û�е�¼����ת����¼ҳ��
			res.sendRedirect("toLogin.do");
			//�жϴ�������
			return false;
		}
		return true;
	}
	
	

}



