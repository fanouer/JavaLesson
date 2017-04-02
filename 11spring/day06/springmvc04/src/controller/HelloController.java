package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	/*
	 * ����һ���쳣������������������������
	 * �׳����쳣��
	 */
	@ExceptionHandler
	public String handleException(
			HttpServletRequest request,
			Exception e){
		if(e instanceof NumberFormatException){
			request.setAttribute("msg", 
					"��������ȷ������");
			return "error";
		}else if(e instanceof 
				StringIndexOutOfBoundsException){
			request.setAttribute("msg", 
			"����Խ��");
			return "error";
		}else{
			return "error3";
		}
		
	}
	
	@RequestMapping("/hello1.do")
	public String hello1(){
		System.out.println("hello1����");
		Integer.parseInt("abc");
		return "hello";
	}
	
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println("hello2����");
		String str = "abcdefg";
		str.charAt(20);
		return "hello";
	}
	
	
}
