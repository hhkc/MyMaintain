package com.jrh.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jrh.dao.UserDao;
import com.jrh.pojo.User;

@Service("userService")
public class UserService implements IUserService{

	@Resource
	UserDao userDao;
	
	public User getUser(String username) {
		User user = userDao.getUser(username);
		return user;
	}

}
