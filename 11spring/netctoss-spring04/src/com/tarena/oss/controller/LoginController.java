package com.tarena.oss.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.oss.entity.Admin;
import com.tarena.oss.service.AdminService;
import com.tarena.oss.service.ApplicationException;
import com.tarena.oss.util.ImageUtil;

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
	
	@ExceptionHandler
	//异常处理方法
	public String execute(
			HttpServletRequest request,
			Exception e){
		if(e instanceof ApplicationException){
			//应用异常
			request.setAttribute("login_failed", 
					e.getMessage());
			return "login";
		}
		//系统异常
		return "error";
	}
	
	@RequestMapping("/login.do")
	public String login(
			HttpServletRequest request,
			HttpSession session){
		//先比较验证码
		//imgCode1:用户提交的验证码
		String imgCode1 = 
			request.getParameter("imgCode");
		//imgCode2:session上保存的验证码
		String imgCode2 = 
			(String)session.getAttribute("imgCode");
		if(!imgCode1.equalsIgnoreCase(imgCode2)){
			//验证码不正确
			request.setAttribute("number_error", 
					"验证码不正确");
			return "login";
		}
		//读取帐号,密码
		String adminCode = 
			request.getParameter("adminCode");
		String pwd = 
			request.getParameter("pwd");
		System.out.println("adminCode:" 
				+ adminCode + " pwd:" + pwd);
		//调用业务层来处理登录请求
		Admin admin = 
			adminService.checkLogin(
				adminCode, pwd);
		//登录成功，绑订admin对象到session
		session.setAttribute("admin", admin);
		return "redirect:index.do";
	}
	
	@RequestMapping("/checkcode.do")
	//生成验证码
	public void checkcode(HttpServletRequest 
			request,
			HttpServletResponse response) 
	throws IOException{
		createImg(request,response);
	}
	
	private void createImg(
			HttpServletRequest req,
			HttpServletResponse res) 
			throws IOException {
			//生成验证码图片
			Object[] objs = ImageUtil.createImage();
			//将验证码存入session
			String imgCode = (String) objs[0];
			req.getSession()
				.setAttribute("imgCode", imgCode);
			//将图片输出给浏览器
			res.setContentType("image/png");
			BufferedImage img = 
				(BufferedImage) objs[1];
			OutputStream os = res.getOutputStream();
			ImageIO.write(img, "png", os);
			os.close();
		}
	
	
	
}
