package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BMIController {
	@RequestMapping("/toBmi.do")
	public String toBmi(){
		return "bmi";
	}
	
	
	@RequestMapping("/bmi.do")
	public String bmi(BmiParam bp,
			ModelMap mm){
		System.out.println("bmi方法");
		double height = bp.getHeight();
		double weight = bp.getWeight();
		System.out.println(height + " " + weight);
		double rs = 
			weight / height / height;
		String status = "正常";
		if(rs > 24){
			status = "过重";
		}else if(rs < 19){
			status = "过轻";
		}
		mm.addAttribute("status", status);
		return "view";
	}
	
	
	
	
	
	
	
}
