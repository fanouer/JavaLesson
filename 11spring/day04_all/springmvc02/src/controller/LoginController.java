package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 二级控制器(处理器)
 *
 */
@Controller
public class LoginController {
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println(
				"LoginController的toLogin方法");
		return "login";
	}
	
	@RequestMapping("/login.do")
	//读取请求参数值的第一种方式:使用request。
	public String checkLogin1(
			HttpServletRequest request){
		System.out.println(
		"LoginController的checkLogin1方法");
		String username = 
			request.getParameter("username");
		String pwd = 
			request.getParameter("pwd");
		System.out.println(username + " " + pwd);
		return "success";
	}
	
	@RequestMapping("/login2.do")
	//读取请求参数值的第二种方式：
	//将方法入参设置为请求参数名。
	//注：如果不一致，可以使用@RequestParam说明。
	public String checkLogin2(String username,
			@RequestParam("pwd") String password){
		System.out.println("checkLogin2方法");
		System.out.println(username + " " 
				+ password);
		return "success";
	}
	
	@RequestMapping("/login3.do")
	//读取请求参数值的第三种方式：
	//使用自动机制封装成一个bean
	public String checkLogin3(User user){
		System.out.println("checkLogin3方法");
		System.out.println(
				user.getUsername() + " " 
				+ user.getPwd());
		return "success";
	}
	
	
	@RequestMapping("/login4.do")
	//向页面传值的第一种方式：
	//绑订数据到request。
	public String checkLogin4(User user,
			HttpServletRequest request){
		System.out.println("checkLogin4方法");
		System.out.println(
				user.getUsername());
		request.setAttribute("user",
				user);
		return "success";
	}
	
	@RequestMapping("/login5.do")
	//向页面传值的第二种方式：
	//使用ModelAndView对象。
	public ModelAndView checkLogin5(
			User user){
		System.out.println("checkLogin5方法");
		System.out.println(user.getUsername());
		Map<String,Object> data = 
			new HashMap<String,Object>();
		//相当于request.setAttribute
		data.put("user", user);
		ModelAndView mav = 
			new ModelAndView("success",data);
		return mav;
	}
	
	@RequestMapping("/login6.do")
	//向页面传值的第三种方式：
	//使用ModelMap对象作为入参。
	public String checkLogin6(User user,
			ModelMap mm){
		System.out.println("checkLogin6方法");
		System.out.println(user.getUsername());
		//相当于request.setAttribute
		mm.addAttribute("user", user);
		return "success";
	}
	
	@RequestMapping("/login7.do")
	//向页面传值的第四种方式：
	//将数据绑订到session。
	public String checkLogin7(User user,
			HttpSession session){
		System.out.println("checkLogin7方法");
		System.out.println(user.getUsername());
		session.setAttribute("user", user);
		return "success";
	}
	
	
}








