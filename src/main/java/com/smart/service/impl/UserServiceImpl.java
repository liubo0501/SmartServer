package com.smart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mapper.UserMapper;
import com.smart.model.ResponseParam;
import com.smart.model.User;
import com.smart.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addUser(User user, ResponseParam responseParam) {
		User oldUser = userMapper.selectByName(user.getUserName());
		if(oldUser!=null){
			responseParam.setStatusCode("400");
			responseParam.setStatusInfo("用户名已经存在");
			return;
		}
		if(userMapper.insert(user)>0){
			responseParam.setStatusCode("200");
			responseParam.setStatusInfo("添加用户成功");
		}else{
			responseParam.setStatusCode("400");
			responseParam.setStatusInfo("添加用户失败");
		}
	}

	@Override
	public void login(User user, ResponseParam responseParam) {
		User oldUser = userMapper.selectByName(user.getUserName());
		if(oldUser==null){
			responseParam.setStatusCode("400");
			responseParam.setStatusInfo("用户名不存在");
		}else{
			if(oldUser.getPassword().equals(user.getPassword())){
				responseParam.setStatusCode("200");
				responseParam.setStatusInfo("登录成功");
			}else{
				responseParam.setStatusCode("400");
				responseParam.setStatusInfo("密码错误");
			}
		}
	}

}
