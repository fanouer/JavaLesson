package com.tarena.oss.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.oss.dao.CostDAO;
import com.tarena.oss.entity.Cost;

@Service("costService")
public class CostServiceImpl implements CostService{
	@Resource(name="costDAO")
	private CostDAO dao;
	public List<Cost> list() {
		return dao.findAll();
	}

}
