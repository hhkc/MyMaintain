package com.jrh.dao;

import org.springframework.stereotype.Repository;

import com.jrh.pojo.User;

@Repository("userDao")
public interface UserDao {
	
	User getUser(String username);
}
