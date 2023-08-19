package com.spring.simple.user.service;

import com.spring.simple.user.vo.UserVO;

public interface UserSevice {
	
	void createUser(UserVO user);
	UserVO getUser(String username);
	void deleteUser(String username);
	int getUserId(String username);
}
