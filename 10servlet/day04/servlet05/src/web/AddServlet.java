package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	private double salary = 3000;
	
	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//��Ҫ���ø���Ĭ�ϵ�service������
		//���������Զ�����doGet/doPost��
		//����2������������д����ܵ��ã�
		//����ᱨ��
		//super.service(req, res);
		
		synchronized (this) {
			
			salary += 100;
			
			//ģ���ӳ�
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			res.setContentType(
				"text/html;charset=utf-8");
			PrintWriter w = res.getWriter();
			w.println("<h1>����:"+salary+"</h1>");
			w.close();
		
		}
	}
	
}






