package org.tedu.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.UserDao;
import org.tedu.cloudnote.entity.User;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;

@Service("userService")//ɨ�赽Spring����
public class UserServiceImpl implements UserService{
	@Resource//ע��
	private UserDao userDao;
	
	public NoteResult checkLogin(
			String name, String password) {
		NoteResult result = new NoteResult();
		User user = userDao.findByName(name);
		//����������ת������
		String md5_password = NoteUtil.md5(password);
		//����û���������
		if(user==null){
			result.setStatus(1);
			result.setMsg("���û�������");
		}else if(!user.getCn_user_password()
					.equals(md5_password)){
			result.setStatus(2);
			result.setMsg("�������");
		}else{
			result.setStatus(0);
			result.setMsg("�û�����������ȷ");
			result.setData(user.getCn_user_id());//�����û�ID
		}
		return result;
	}

	public NoteResult registUser(
		String name, String nick, String password) {
		NoteResult result = new NoteResult();
		//�û������
		User hasUser = userDao.findByName(name);
		if(hasUser != null){
			result.setStatus(1);
			result.setMsg("�û����Ѵ���");
			return result;
		}
		//ִ��ע�ᴦ��
		User user = new User();
		user.setCn_user_name(name);//�û���
		user.setCn_user_nick(nick);//�ǳ�
		String md5_password = NoteUtil.md5(password);
		user.setCn_user_password(md5_password);//����
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);//�û�ID
		user.setCn_user_token("");
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("ע��ɹ�");
		return result;
	}

}


