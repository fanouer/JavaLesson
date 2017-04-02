package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//����Cookie
		Cookie c1 = 
			new Cookie("user","zhangsan");
		//cookieĬ�ϴ浽�ڴ����������
		//�洢��Ӳ���ϣ�����ָ������ʱ�䡣
		//�������ʱ��cookie���Զ���ɾ����
		c1.setMaxAge(36000);
		//��Cookie���͸������
		res.addCookie(c1);
		
		//����cookie��������
		Cookie c2 = new Cookie("city",
			URLEncoder.encode("����","utf-8"));
		res.addCookie(c2);
		
	}

	
	
}








