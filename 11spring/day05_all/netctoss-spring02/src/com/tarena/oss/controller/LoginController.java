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
		System.out.println("toLogin����");
		return "login";
	}
	
	@RequestMapping("/index.do")
	public String toIndex(){
		System.out.println("toIndex����");
		return "index";
	}
	
	@RequestMapping("/login.do")
	public String login(
			HttpServletRequest request,
			HttpSession session){
		//��ȡ�ʺ�,����
		String adminCode = 
			request.getParameter("adminCode");
		String pwd = 
			request.getParameter("pwd");
		System.out.println("adminCode:" 
				+ adminCode + " pwd:" + pwd);
		//����ҵ����������¼����
		try{
			Admin admin = 
				adminService.checkLogin(
						adminCode, pwd);
			//��¼�ɹ�����admin����session
			session.setAttribute("admin", admin);
		}catch(Exception e){
			//����־
			e.printStackTrace();
			/*
			 * ���쳣�ܷ�ָ�������ܹ��ָ�
			 * (Ӧ���쳣),����ʾ�û���ȡ��ȷ��
			 * ������������ܹ��ָ�(ϵͳ�쳣),
			 * ����ʾ�û��Ժ����ԡ�
			 */
			if(e instanceof ApplicationException){
				//Ӧ���쳣����ʾ�û���ȡ��ȷ�Ĳ���
				request.setAttribute("adminCode", adminCode);
				request.setAttribute(
						"login_failed", e.getMessage());
				return "login";
			}
			//ϵͳ�쳣����ʾ�û��Ժ�����
			return "error";
		}
		//��¼�ɹ�����ת����ҳ��
		/*
		 * ����ض���:
		 * ����1��
		 * ��������ķ���ֵ��String,����ͼ��ǰ���
		 * "redirect:"��
		 * ����2��
		 * ��������ķ���ֵ��ModelAndView
		 * RedirectView rv = 
		 * new RedirectView("toLogin.do");
		 * return new ModelAndView(rv);
		 */
		
		return "redirect:index.do";
	}
	
	
	
	
	
}
