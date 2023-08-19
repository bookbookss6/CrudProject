package com.spring.simple.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.simple.user.repository.UserDAO;
import com.spring.simple.user.service.UserSevice;
import com.spring.simple.user.vo.UserVO;

@Service
public class UserServiceImpl implements UserSevice{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void createUser(UserVO user) {
		
		userDAO.insertUser(user);
	}

	@Override
	public UserVO getUser(String username) {
		return userDAO.selectUser(username);
	}

	@Override
	public void deleteUser(String username) {
		userDAO.deleteUser(username); 
	}

	@Override
	public int getUserId(String username) {
		return userDAO.getUserId(username);
	}

}
