package org.tedu.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.UserDao;
import org.tedu.cloudnote.entity.User;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;

@Service("userService")//扫描到Spring容器
public class UserServiceImpl implements UserService{
	@Resource//注入
	private UserDao userDao;
	
	public NoteResult checkLogin(
			String name, String password) {
		NoteResult result = new NoteResult();
		User user = userDao.findByName(name);
		//将明文密码转成密文
		String md5_password = NoteUtil.md5(password);
		//检查用户名和密码
		if(user==null){
			result.setStatus(1);
			result.setMsg("该用户不存在");
		}else if(!user.getCn_user_password()
					.equals(md5_password)){
			result.setStatus(2);
			result.setMsg("密码错误");
		}else{
			result.setStatus(0);
			result.setMsg("用户名和密码正确");
			result.setData(user.getCn_user_id());//返回用户ID
		}
		return result;
	}

	public NoteResult registUser(
		String name, String nick, String password) {
		NoteResult result = new NoteResult();
		//用户名检测
		User hasUser = userDao.findByName(name);
		if(hasUser != null){
			result.setStatus(1);
			result.setMsg("用户名已存在");
			return result;
		}
		//执行注册处理
		User user = new User();
		user.setCn_user_name(name);//用户名
		user.setCn_user_nick(nick);//昵称
		String md5_password = NoteUtil.md5(password);
		user.setCn_user_password(md5_password);//密码
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);//用户ID
		user.setCn_user_token("");
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("注册成功");
		return result;
	}

}


