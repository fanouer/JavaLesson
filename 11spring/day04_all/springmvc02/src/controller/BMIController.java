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
		System.out.println("bmi����");
		double height = bp.getHeight();
		double weight = bp.getWeight();
		System.out.println(height + " " + weight);
		double rs = 
			weight / height / height;
		String status = "����";
		if(rs > 24){
			status = "����";
		}else if(rs < 19){
			status = "����";
		}
		mm.addAttribute("status", status);
		return "view";
	}
	
	
	
	
	
	
	
}
