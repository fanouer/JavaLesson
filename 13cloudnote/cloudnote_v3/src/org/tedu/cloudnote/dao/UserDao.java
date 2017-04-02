package org.tedu.cloudnote.dao;

import org.tedu.cloudnote.entity.User;

public interface UserDao {
	
	public User findByName(String name);
	
	public void save(User user);
	
}
