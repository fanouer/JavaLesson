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
 * ����������(������)
 *
 */
@Controller
public class LoginController {
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println(
				"LoginController��toLogin����");
		return "login";
	}
	
	@RequestMapping("/login.do")
	//��ȡ�������ֵ�ĵ�һ�ַ�ʽ:ʹ��request��
	public String checkLogin1(
			HttpServletRequest request){
		System.out.println(
		"LoginController��checkLogin1����");
		String username = 
			request.getParameter("username");
		String pwd = 
			request.getParameter("pwd");
		System.out.println(username + " " + pwd);
		return "success";
	}
	
	@RequestMapping("/login2.do")
	//��ȡ�������ֵ�ĵڶ��ַ�ʽ��
	//�������������Ϊ�����������
	//ע�������һ�£�����ʹ��@RequestParam˵����
	public String checkLogin2(String username,
			@RequestParam("pwd") String password){
		System.out.println("checkLogin2����");
		System.out.println(username + " " 
				+ password);
		return "success";
	}
	
	@RequestMapping("/login3.do")
	//��ȡ�������ֵ�ĵ����ַ�ʽ��
	//ʹ���Զ����Ʒ�װ��һ��bean
	public String checkLogin3(User user){
		System.out.println("checkLogin3����");
		System.out.println(
				user.getUsername() + " " 
				+ user.getPwd());
		return "success";
	}
	
	
	@RequestMapping("/login4.do")
	//��ҳ�洫ֵ�ĵ�һ�ַ�ʽ��
	//�����ݵ�request��
	public String checkLogin4(User user,
			HttpServletRequest request){
		System.out.println("checkLogin4����");
		System.out.println(
				user.getUsername());
		request.setAttribute("user",
				user);
		return "success";
	}
	
	@RequestMapping("/login5.do")
	//��ҳ�洫ֵ�ĵڶ��ַ�ʽ��
	//ʹ��ModelAndView����
	public ModelAndView checkLogin5(
			User user){
		System.out.println("checkLogin5����");
		System.out.println(user.getUsername());
		Map<String,Object> data = 
			new HashMap<String,Object>();
		//�൱��request.setAttribute
		data.put("user", user);
		ModelAndView mav = 
			new ModelAndView("success",data);
		return mav;
	}
	
	@RequestMapping("/login6.do")
	//��ҳ�洫ֵ�ĵ����ַ�ʽ��
	//ʹ��ModelMap������Ϊ��Ρ�
	public String checkLogin6(User user,
			ModelMap mm){
		System.out.println("checkLogin6����");
		System.out.println(user.getUsername());
		//�൱��request.setAttribute
		mm.addAttribute("user", user);
		return "success";
	}
	
	@RequestMapping("/login7.do")
	//��ҳ�洫ֵ�ĵ����ַ�ʽ��
	//�����ݰ󶩵�session��
	public String checkLogin7(User user,
			HttpSession session){
		System.out.println("checkLogin7����");
		System.out.println(user.getUsername());
		session.setAttribute("user", user);
		return "success";
	}
	
	
}








