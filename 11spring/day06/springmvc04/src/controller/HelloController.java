package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	/*
	 * 这是一个异常处理方法，用来处理其它方法
	 * 抛出的异常。
	 */
	@ExceptionHandler
	public String handleException(
			HttpServletRequest request,
			Exception e){
		if(e instanceof NumberFormatException){
			request.setAttribute("msg", 
					"请输入正确的数字");
			return "error";
		}else if(e instanceof 
				StringIndexOutOfBoundsException){
			request.setAttribute("msg", 
			"数组越界");
			return "error";
		}else{
			return "error3";
		}
		
	}
	
	@RequestMapping("/hello1.do")
	public String hello1(){
		System.out.println("hello1方法");
		Integer.parseInt("abc");
		return "hello";
	}
	
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println("hello2方法");
		String str = "abcdefg";
		str.charAt(20);
		return "hello";
	}
	
	
}
