package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements 
HandlerInterceptor{

	/**
	 * �����������̽���֮��
		ִ�С�
		arg2:  �����������ķ�������
		e: �����������ķ����׳����쳣��
	 */
	public void afterCompletion(
			HttpServletRequest req,
			HttpServletResponse res, 
			Object arg2, Exception e)
			throws Exception {
		System.out.println(
		"SomeInterceptor��afterCompletion����");
	}

	/**
	 * �����������ķ����Ѿ�ִ��
	��ϣ��ڷ���ModelAndView�����
	ǰ�˿�����֮ǰ��ִ�С������ڸ÷������棬
	�޸�ModelAndView�е����ݡ�
	arg2:  �����������ķ�������
	 */
	public void postHandle(
			HttpServletRequest req, 
			HttpServletResponse res,
			Object arg2, ModelAndView mav) 
	throws Exception {
		System.out.println(
			"SomeInterceptor��postHandle����");
	
	}

	/**
	 * ǰ�˿��������ö���������
	     ֮ǰ��ִ�С�����÷�������ֵΪtrue,
	     ��ʾ���������ã��������ֵΪfalse,
	     �жϴ���
	   arg2:  �����������ķ�������
	 */
	public boolean preHandle(
			HttpServletRequest req, 
			HttpServletResponse res,
			Object arg2) throws Exception {
		System.out.println(
			"SomeInterceptor��preHandle����");
		return true;
	}

}
