package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dao.EmpDaoImpl;
import entity.Emp;

public class FindEmpServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//查询全部员工
		EmpDao dao = new EmpDaoImpl();
		List<Emp> list = dao.findAll();
		
		//生成响应信息：员工表格
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		
		w.println("<!doctype html>");
		w.println("<html>");
		w.println("	<head>");
		w.println("	  <meta charset='utf-8'/>");
		w.println("	  <title>查询员工</title>");
		w.println("	</head>");
		w.println("	<body>");
		
		w.println("	  <input type='button' value='增加' onclick='location.href=\"add_emp.html\"'/>");
		
		w.println("	  <table border='1px' width='40%' cellspacing='0'>");
		w.println("		<tr>");
		w.println("		  <th>编号</th>");
		w.println("		  <th>姓名</th>");
		w.println("		  <th>职位</th>");
		w.println("		  <th>工资</th>");
		w.println("		</tr>");
		
		for(Emp e : list) {
			w.println("	<tr>");
			w.println("	  <td>"+e.getEmpno()+"</td>");
			w.println("	  <td>"+e.getEname()+"</td>");
			w.println("	  <td>"+e.getJob()+"</td>");
			w.println("	  <td>"+e.getSal()+"</td>");
			w.println("	</tr>");
		}
		
		w.println("	  </table>");
		w.println("	</body>");
		w.println("</html>");
		
		w.close();
	}

	
	
}






