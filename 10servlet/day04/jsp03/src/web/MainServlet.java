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
 * �淶��
 * ��ѯ���ţ�/jsp03/findDept.do
 */
public class MainServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//��ѯ���в���
		DeptDao dao = new DeptDaoImpl();
		List<Dept> list = dao.findAll();
		//������ת����JSP
		//1.�����ݰ󶨵�request��
		req.setAttribute("depts", list);
		//2.ʵ��ת��
		//��ǰ��/jsp03/findDept.do
		//Ŀ�꣺/jsp03/find_dept.jsp
		req.getRequestDispatcher(
			"find_dept.jsp").forward(req, res);
	}

	
	
}







