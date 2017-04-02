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
		//��ȡ�������
		req.setCharacterEncoding("utf-8");
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		Double salary = null;
		if(sal != null && !sal.equals("")) {
			salary = new Double(sal);
		}
		//����Щ���ݴ������
		EmpDao dao = new EmpDaoImpl();
		Emp e = new Emp();
		e.setEname(ename);
		e.setJob(job);
		e.setSal(salary);
		dao.save(e);
		//������Ӧ��Ϣ
//		res.setContentType(
//			"text/html;charset=utf-8");
//		PrintWriter w = res.getWriter();
//		w.println("<h1>����ɹ�</h1>");
//		w.close();
		//�ض��򵽲�ѯ����
		//�ض������Ϊ�������ת��ʽ
		//Ҳ��һ���������Ӧ��ʽ
		//��ǰ��/EmpManager/addEmp
		//Ŀ�꣺/EmpManager/findEmp
		res.sendRedirect("findEmp");
	}

	
	
}













