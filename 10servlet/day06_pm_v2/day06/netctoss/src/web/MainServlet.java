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
		//根据规范判断请求路径
		String path = req.getServletPath();
		if("/findCost.do".equals(path)) {
			//查询所有的资费
			findCost(req, res);
		} else if("/toAddCost.do".equals(path)) {
			//打开增加资费页
			toAddCost(req, res);
		} else if("/addCost.do".equals(path)) {
			//增加保存资费
			addCost(req, res);
		} else if("/toUpdateCost.do".equals(path)) {
			//打开修改资费页
			toUpdateCost(req, res);
		} else {
			//错误的路径
			throw new RuntimeException(
				"查无此页");
		}
	}
	
	private void toUpdateCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//获取请求参数
		String id = req.getParameter("id");
		//查询此资费
		CostDao dao = new CostDaoImpl();
		Cost cost = 
			dao.findById(new Integer(id));
		//转发到修改页
		req.setAttribute("cost", cost);
		//当前：/netctoss/toUpdateCost.do
		//目标：/netctoss/WEB-INF/cost/update.jsp
		req.getRequestDispatcher(
			"WEB-INF/cost/update.jsp")
			.forward(req, res);
	}
	
	private void addCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws IOException {
		req.setCharacterEncoding("utf-8");
		//接收请求参数
		String name = req.getParameter("name");
		String baseDuration = 
			req.getParameter("baseDuration");
		String baseCost = 
			req.getParameter("baseCost");
		String unitCost = 
			req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		String costType = req.getParameter("costType");
		//保存资费
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
		//重定向到查询资费
		//当前：/netctoss/addCost.do
		//目标：/netctoss/findCost.do
		res.sendRedirect("findCost.do");
	}
	
	private void toAddCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//转发到增加页面
		//当前：/netctoss/toAddCost.do
		//目标：/netctoss/WEB-INF/cost/add.jsp
		req.getRequestDispatcher(
			"WEB-INF/cost/add.jsp")
			.forward(req, res);
	}
	
	private void findCost(
		HttpServletRequest req,
		HttpServletResponse res) 
		throws ServletException, IOException {
		//查询所有资费
		CostDao dao = new CostDaoImpl();
		List<Cost> list = dao.findAll();
		//转发到查询页
		req.setAttribute("costs", list);
		//当前:/netctoss/findCost.do
		//目标:/netctoss/WEB-INF/cost/find.jsp
		req.getRequestDispatcher(
			"WEB-INF/cost/find.jsp")
			.forward(req, res);
	}
	
}










