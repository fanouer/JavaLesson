package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet 
	extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//����ʵ�����ݵĽ��뷽ʽ��
		//������ȡ����ǰд����Ч��
		//���Խ��post���������������⡣
		req.setCharacterEncoding("utf-8");
		
		//1.��ȡ�������
		//��ȡ����ֵ
		String code = req.getParameter("code");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		
		//���get/post����ʱ����������
//		byte[] bs = code.getBytes("iso8859-1");
//		code = new String(bs, "utf-8");
		
		//��ȡ���ֵ
		String[] interests = 
			req.getParameterValues("interest");
		//2.����ҵ��
		System.out.println("�˺�:"+code);
		System.out.println("����:"+pwd);
		System.out.println("�Ա�:"+sex);
		if(interests != null) {
			for(String itst : interests) {
				System.out.println(itst);
			}
		}
		//3.������Ӧ
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("<h1>ע��ɹ�</h1>");
		w.close();
	}

	
	
}








