package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello1.do")
	public String hello1(){
		System.out.println("hello1方法");
		return "hello";
	}
	
	@RequestMapping("/demo/hello2.do")
	public String hello2(){
		System.out.println("hello2方法");
		return "hello";
	}
}
