package web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CostDao;
import dao.CostDaoImpl;
import entity.Cost;

public class MainServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//���ݹ淶�ж�����·��
		String path = req.getServletPath();
		if("/findCost.do".equals(path)) {
			//��ѯ���е��ʷ�
			findCost(req, res);
		} else if("/toAddCost.do".equals(path)) {
			//�������ʷ�ҳ
			toAddCost(req, res);
		} else if("/addCost.do".equals(path)) {
			//���ӱ����ʷ�
			addCost(req, res);
		} else if("/toUpdateCost.do".equals(path)) {
			//���޸��ʷ�ҳ
			toUpdateCost(req, res);
		} else {
			//�����·��
			throw new RuntimeException(
				"���޴�ҳ");
		}
	}
	
	private void toUpdateCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//��ȡ�������
		String id = req.getParameter("id");
		//��ѯ���ʷ�
		CostDao dao = new CostDaoImpl();
		Cost cost = 
			dao.findById(new Integer(id));
		//ת�����޸�ҳ
		req.setAttribute("cost", cost);
		//��ǰ��/netctoss/toUpdateCost.do
		//Ŀ�꣺/netctoss/WEB-INF/cost/update.jsp
		req.getRequestDispatcher(
			"WEB-INF/cost/update.jsp")
			.forward(req, res);
	}
	
	private void addCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws IOException {
		req.setCharacterEncoding("utf-8");
		//�����������
		String name = req.getParameter("name");
		String baseDuration = 
			req.getParameter("baseDuration");
		String baseCost = 
			req.getParameter("baseCost");
		String unitCost = 
			req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		String costType = req.getParameter("costType");
		//�����ʷ�
		Cost c = new Cost();
		c.setName(name);
		c.setDescr(descr);
		c.setCostType(costType);
		if(baseDuration != null
			&& !"".equals(baseDuration)) {
			c.setBaseDuration(
				new Integer(baseDuration));
		}
		if(baseCost != null
			&& !"".equals(baseCost)) {
			c.setBaseCost(
				new Double(baseCost));
		}
		if(unitCost != null
			&& !"".equals(unitCost)) {
			c.setUnitCost(
				new Double(unitCost));
		}
		CostDao dao = new CostDaoImpl();
		dao.save(c);
		//�ض��򵽲�ѯ�ʷ�
		//��ǰ��/netctoss/addCost.do
		//Ŀ�꣺/netctoss/findCost.do
		res.sendRedirect("findCost.do");
	}
	
	private void toAddCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//ת��������ҳ��
		//��ǰ��/netctoss/toAddCost.do
		//Ŀ�꣺/netctoss/WEB-INF/cost/add.jsp
		req.getRequestDispatcher(
			"WEB-INF/cost/add.jsp")
			.forward(req, res);
	}
	
	private void findCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//��ѯ�����ʷ�
		CostDao dao = new CostDaoImpl();
		List<Cost> list = dao.findAll();
		//ת������ѯҳ
		req.setAttribute("costs", list);
		//��ǰ:/netctoss/findCost.do
		//Ŀ��:/netctoss/WEB-INF/cost/find.jsp
		req.getRequestDispatcher(
			"WEB-INF/cost/find.jsp")
			.forward(req, res);
	}
	
}










