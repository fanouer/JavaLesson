package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;
import dao.DeptDaoImpl;
import entity.Dept;

/**
 * 规范：
 * 查询部门：/jsp03/findDept.do
 */
public class MainServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//查询所有部门
		DeptDao dao = new DeptDaoImpl();
		List<Dept> list = dao.findAll();
		//将请求转发到JSP
		//1.将数据绑定到request上
		req.setAttribute("depts", list);
		//2.实现转发
		//当前：/jsp03/findDept.do
		//目标：/jsp03/find_dept.jsp
		req.getRequestDispatcher(
			"find_dept.jsp").forward(req, res);
	}

	
	
}







