package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dao.EmpDaoImpl;
import entity.Emp;

/**
 * 统一处理所有的请求。
 * 
 * 规范：
 *  查询员工：findEmp.do
 *  新增员工：addEmp.do
 * 
 */
public class MainServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//根据规范判断请求路径
		String path = req.getServletPath();
		if("/findEmp.do".equals(path)) {
			//查询员工
			findEmp(req, res);
		} else if("/addEmp.do".equals(path)) {
			//新增员工
			addEmp(req, res);
		}
	}

	private void addEmp(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws IOException {
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
		//当前：/EmpManager/addEmp.do
		//目标：/EmpManager/findEmp.do
		res.sendRedirect("findEmp.do");		
	}
	
	private void findEmp(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws IOException {
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







