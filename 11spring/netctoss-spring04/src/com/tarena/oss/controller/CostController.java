package com.tarena.oss.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.oss.entity.Cost;
import com.tarena.oss.service.CostService;

@Controller
public class CostController {
	@Resource(name="costService")
	private CostService service;
	@RequestMapping("/cost.do")
	public String cost(HttpServletRequest request){
		System.out.println("cost·½·¨");
		List<Cost> costs = 
			service.list();
		request.setAttribute("costs", costs);
		return "cost";
	}
}
