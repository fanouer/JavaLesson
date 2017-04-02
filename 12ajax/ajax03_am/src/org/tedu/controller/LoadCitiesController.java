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
	@ResponseBody//����������ֵת��JSON���
	public List<City> execute(){
		City c1 = new City(101,"�人");
		City c2 = new City(102,"�ɶ�");
		City c3 = new City(103,"����");
		List<City> list = new ArrayList<City>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		return list;
	}
	
}
