package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dao.EmpDaoImpl;
import entity.Emp;

public class AddEmpServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//获取请求参数
		req.setCharacterEncoding("utf-8");
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		Double salary = null;
		if(sal != null && !sal.equals("")) {
			salary = new Double(sal);
		}
		//将这些数据存入库中
		EmpDao dao = new EmpDaoImpl();
		Emp e = new Emp();
		e.setEname(ename);
		e.setJob(job);
		e.setSal(salary);
		dao.save(e);
		//生成响应信息
//		res.setContentType(
//			"text/html;charset=utf-8");
//		PrintWriter w = res.getWriter();
//		w.println("<h1>保存成功</h1>");
//		w.close();
		//重定向到查询功能
		//重定向：理解为特殊的跳转方式
		//也是一种特殊的响应方式
		//当前：/EmpManager/addEmp
		//目标：/EmpManager/findEmp
		res.sendRedirect("findEmp");
	}

	
	
}













