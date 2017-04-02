package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//1.��ȡ��������
		//1.1������
		System.out.println(
			"Э������:"+req.getProtocol());
		System.out.println(
			"����ʽ:"+req.getMethod());
		System.out.println(
			"Servlet·��:"+req.getServletPath());
		//1.2��Ϣͷ(key-value)
		//hearderNames�����е�key��
		//Enumeration������key�ĵ�������
		//���Ǳ�Iterator�����ϵĵ�������
		Enumeration<String> e = 
			req.getHeaderNames();
		while(e.hasMoreElements()) {
			String key = e.nextElement();
			String value = req.getHeader(key);
			System.out.println(
				key + ":" + value);
		}
		//1.3ʵ������
		//���ڱ�����û�и�Servlet�����ݣ�
		//���ʵ�������ǿյģ������ٽ���
		
		//2.д��Ӧ����
		//2.1״̬��
		//��������Tomcat�Զ�д��
		//2.2��Ϣͷ
		res.setContentType("text/html");
		PrintWriter w = res.getWriter();
		
		Date date = new Date();
		SimpleDateFormat sdf = 
			new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(date);
		
		//2.3ʵ������
		w.println("<h1>");
		w.println(now);
		w.println("</h1>");
		
		w.close();
	}

	
	
}






