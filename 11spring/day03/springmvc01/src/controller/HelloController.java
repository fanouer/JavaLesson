package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Controller(����������): ����������
 * 1. ʵ��Controller�ӿ�
 * 2. ��handleRequest�����������
 *   ����Ĵ���
 */
public class HelloController 
implements Controller{

	public ModelAndView handleRequest(
			HttpServletRequest req,
			HttpServletResponse res) 
	throws Exception {
		System.out.println("HelloController��" +
				"handleRequest����");
		/*
		 * ModelAndView������������:
		 * ModelAndView(String viewName)
		 * ע��
		 * 	viewName����ͼ��(�߼�����)����Ҫ��
		 *  ViewResolverȥ��������������ͼ
		 *  ����(���磬ĳ��JSP)��
		 * ModelAndView(String viewName, Map data)
		 * ע��
		 * 	data�Ǵ�������
		 */
		return new ModelAndView("hello");
	}
	
}





