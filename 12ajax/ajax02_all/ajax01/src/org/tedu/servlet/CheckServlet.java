package org.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet{
	
	public void service(
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException,ServletException{
		
		//��ȡ�����ύ���û���key=name
		request.setCharacterEncoding("utf-8");
		String name = 
			request.getParameter("name");
		System.out.println("==="+name);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�ж�name�Ƿ����
		response.setContentType(
			"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if("scott".equals(name) 
			|| "tiger".equals(name)){
			out.print("�û����ѱ�ռ��");
		}else{
			out.print("�û�������");
		}
		out.flush();
		out.close();
	}
	
}



