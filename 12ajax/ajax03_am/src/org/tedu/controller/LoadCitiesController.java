package org.tedu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.entity.City;

@Controller
public class LoadCitiesController {

	@RequestMapping("/loadcities.do")
	@ResponseBody//将方法返回值转成JSON输出
	public List<City> execute(){
		City c1 = new City(101,"武汉");
		City c2 = new City(102,"成都");
		City c3 = new City(103,"西安");
		List<City> list = new ArrayList<City>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		return list;
	}
	
}
