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
		//模拟查询学生
		Student s = new Student();
		s.setCode("007");
		s.setName("Tarena");
		s.setAge(20);
		s.setSex("M");
		s.setInterests(
			new String[]{"篮球","足球","台球"});
		Course c = new Course();
		c.setId(1);
		c.setName("Java");
		c.setDays(80);
		s.setCourse(c);
		//转发到JSP
		//当前：/jsp04/demo
		//目标：/jsp04/demo.jsp
		req.setAttribute("stu", s);
		req.getRequestDispatcher(
			"demo.jsp").forward(req, res);
	}

	
	
}





