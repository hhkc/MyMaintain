package com.jrh.pojo;

public class User {
	private String user_name;
	private String password;
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", password=" + password + "]";
	}
	
	
	
	
}
