package com.smart.service;

import com.smart.model.ResponseParam;
import com.smart.model.User;

public interface UserService {

	void addUser(User user, ResponseParam responseParam);
	
	void login(User user,ResponseParam responseParam);
}
