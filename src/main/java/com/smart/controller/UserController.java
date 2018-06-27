package com.smart.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.model.ResponseParam;
import com.smart.model.User;
import com.smart.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping("/addUser")
//	// {"event":"login","param":{"platform":"1","username":"liubo@anbot.cn","password":"6846860684f05029abccc09a53cd66f1"}}  不要data postman 选raw JSON
//	public ResponseParam addUser(@RequestBody RequestParam data){
//		
//		
//	}
	
	@RequestMapping("/addUser/{userName}/{password}")
	public ResponseParam addUser(@PathVariable String userName,@PathVariable String password){
		ResponseParam responseparam = new ResponseParam();
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setCreateTime(new Date());
		userService.addUser(user,responseparam);
		return responseparam;
	}

	@RequestMapping("/login/{userName}/{password}")
	public ResponseParam login(@PathVariable String userName,@PathVariable String password){
		ResponseParam responseparam = new ResponseParam();
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setCreateTime(new Date());
		userService.login(user,responseparam);
		return responseparam;
	}

}
