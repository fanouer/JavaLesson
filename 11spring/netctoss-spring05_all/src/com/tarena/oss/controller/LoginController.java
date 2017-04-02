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
		System.out.println("toLogin����");
		return "login";
	}
	
	@RequestMapping("/index.do")
	public String toIndex(){
		System.out.println("toIndex����");
		return "index";
	}
	
	@ExceptionHandler
	//�쳣������
	public String execute(
			HttpServletRequest request,
			Exception e){
		if(e instanceof ApplicationException){
			//Ӧ���쳣
			request.setAttribute("login_failed", 
					e.getMessage());
			return "login";
		}
		//ϵͳ�쳣
		return "error";
	}
	
	@RequestMapping("/login.do")
	public String login(
			HttpServletRequest request,
			HttpSession session){
		//�ȱȽ���֤��
		//imgCode1:�û��ύ����֤��
		String imgCode1 = 
			request.getParameter("imgCode");
		//imgCode2:session�ϱ������֤��
		String imgCode2 = 
			(String)session.getAttribute("imgCode");
		if(!imgCode1.equalsIgnoreCase(imgCode2)){
			//��֤�벻��ȷ
			request.setAttribute("number_error", 
					"��֤�벻��ȷ");
			return "login";
		}
		//��ȡ�ʺ�,����
		String adminCode = 
			request.getParameter("adminCode");
		String pwd = 
			request.getParameter("pwd");
		System.out.println("adminCode:" 
				+ adminCode + " pwd:" + pwd);
		//����ҵ����������¼����
		Admin admin = 
			adminService.checkLogin(
				adminCode, pwd);
		//��¼�ɹ�����admin����session
		session.setAttribute("admin", admin);
		return "redirect:index.do";
	}
	
	@RequestMapping("/checkcode.do")
	//������֤��
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
			//������֤��ͼƬ
			Object[] objs = ImageUtil.createImage();
			//����֤�����session
			String imgCode = (String) objs[0];
			req.getSession()
				.setAttribute("imgCode", imgCode);
			//��ͼƬ����������
			res.setContentType("image/png");
			BufferedImage img = 
				(BufferedImage) objs[1];
			OutputStream os = res.getOutputStream();
			ImageIO.write(img, "png", os);
			os.close();
		}
	
	
	
}
