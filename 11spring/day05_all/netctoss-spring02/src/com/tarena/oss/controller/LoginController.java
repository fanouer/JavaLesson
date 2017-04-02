package com.tarena.oss.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.oss.entity.Admin;
import com.tarena.oss.service.AdminService;
import com.tarena.oss.service.ApplicationException;

@Controller
public class LoginController {
	@Resource(name="adminService")
	private AdminService adminService;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin方法");
		return "login";
	}
	
	@RequestMapping("/index.do")
	public String toIndex(){
		System.out.println("toIndex方法");
		return "index";
	}
	
	@RequestMapping("/login.do")
	public String login(
			HttpServletRequest request,
			HttpSession session){
		//读取帐号,密码
		String adminCode = 
			request.getParameter("adminCode");
		String pwd = 
			request.getParameter("pwd");
		System.out.println("adminCode:" 
				+ adminCode + " pwd:" + pwd);
		//调用业务层来处理登录请求
		try{
			Admin admin = 
				adminService.checkLogin(
						adminCode, pwd);
			//登录成功，绑订admin对象到session
			session.setAttribute("admin", admin);
		}catch(Exception e){
			//记日志
			e.printStackTrace();
			/*
			 * 看异常能否恢复，如果能够恢复
			 * (应用异常),则提示用户采取正确的
			 * 操作；如果不能够恢复(系统异常),
			 * 则提示用户稍后重试。
			 */
			if(e instanceof ApplicationException){
				//应用异常，提示用户采取正确的操作
				request.setAttribute("adminCode", adminCode);
				request.setAttribute(
						"login_failed", e.getMessage());
				return "login";
			}
			//系统异常，提示用户稍后重试
			return "error";
		}
		//登录成功，跳转到首页。
		/*
		 * 如何重定向:
		 * 情形1：
		 * 如果方法的返回值是String,在视图名前添加
		 * "redirect:"。
		 * 情形2：
		 * 如果方法的返回值是ModelAndView
		 * RedirectView rv = 
		 * new RedirectView("toLogin.do");
		 * return new ModelAndView(rv);
		 */
		
		return "redirect:index.do";
	}
	
	
	
	
	
}
