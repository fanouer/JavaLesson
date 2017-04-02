package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//������������ݵ�����
		res.setContentType("text/html");
		//��ȡ��
		PrintWriter pw = res.getWriter();
		
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/DD  HH:mm:ss");
		String now=sdf.format(date);
		
		//�������(��̬ƴһ����ҳ)
		pw.println("<p>");
		pw.println(now);
		pw.println("</p>");
		
		//�ر���
		pw.close();
	}

	
	
}









