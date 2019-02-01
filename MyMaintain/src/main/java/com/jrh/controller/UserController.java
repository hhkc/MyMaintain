package com.jrh.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jrh.pojo.User;
import com.jrh.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	 private static Logger log=LoggerFactory.getLogger(UserController.class);
	 
	 @Autowired
	 IUserService userService;
	 
	 @RequestMapping(value="/getUserInfo",method=RequestMethod.GET)  
	 public String getUserInfo(HttpServletRequest request,Model model){  
        System.out.println("#######test######");
        User user = userService.getUser("Öì×÷»Ô");
        System.out.println(user.toString());
        return "test";
	 }  
}
