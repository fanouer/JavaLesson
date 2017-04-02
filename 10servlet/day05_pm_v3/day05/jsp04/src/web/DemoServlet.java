package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import entity.Student;

public class DemoServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//ģ���ѯѧ��
		Student s = new Student();
		s.setCode("007");
		s.setName("Tarena");
		s.setAge(20);
		s.setSex("M");
		s.setInterests(
			new String[]{"����","����","̨��"});
		Course c = new Course();
		c.setId(1);
		c.setName("Java");
		c.setDays(80);
		s.setCourse(c);
		//ת����JSP
		//��ǰ��/jsp04/demo
		//Ŀ�꣺/jsp04/demo.jsp
		req.setAttribute("stu", s);
		req.getRequestDispatcher(
			"demo.jsp").forward(req, res);
	}

	
	
}





