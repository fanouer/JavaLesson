package org.tedu.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.UserService;
import org.tedu.cloudnote.util.NoteResult;

@Controller("loginController")
@RequestMapping("/user")
public class UserLoginController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody//��result���ת��json���
	public NoteResult execute(
		String name,String password){
		NoteResult result = 
			userService.checkLogin(name, password);
		return result;
	}
	
}
