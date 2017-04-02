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
 * ͳһ�������е�����
 * 
 * �淶��
 *  ��ѯԱ����findEmp.do
 *  ����Ա����addEmp.do
 * 
 */
public class MainServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//���ݹ淶�ж�����·��
		String path = req.getServletPath();
		if("/findEmp.do".equals(path)) {
			//��ѯԱ��
			findEmp(req, res);
		} else if("/addEmp.do".equals(path)) {
			//����Ա��
			addEmp(req, res);
		}
	}

	private void addEmp(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws IOException {
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
		//��ǰ��/EmpManager/addEmp.do
		//Ŀ�꣺/EmpManager/findEmp.do
		res.sendRedirect("findEmp.do");		
	}
	
	private void findEmp(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws IOException {
		//��ѯȫ��Ա��
		EmpDao dao = new EmpDaoImpl();
		List<Emp> list = dao.findAll();
		
		//������Ӧ��Ϣ��Ա�����
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		
		w.println("<!doctype html>");
		w.println("<html>");
		w.println("	<head>");
		w.println("	  <meta charset='utf-8'/>");
		w.println("	  <title>��ѯԱ��</title>");
		w.println("	</head>");
		w.println("	<body>");
		
		w.println("	  <input type='button' value='����' onclick='location.href=\"add_emp.html\"'/>");
		
		w.println("	  <table border='1px' width='40%' cellspacing='0'>");
		w.println("		<tr>");
		w.println("		  <th>���</th>");
		w.println("		  <th>����</th>");
		w.println("		  <th>ְλ</th>");
		w.println("		  <th>����</th>");
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







