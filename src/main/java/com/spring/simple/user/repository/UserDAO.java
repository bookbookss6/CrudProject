package com.spring.simple.user.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.simple.user.vo.UserVO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insertUser(UserVO user)
	{
		return mybatis.insert("user.insert_user",user);
	}
	
	public UserVO selectUser(String username)
	{
		return mybatis.selectOne("user.select_user",username);
	}
	public int deleteUser(String username)
	{
		return mybatis.delete("user.delete_user",username);
	}
	public int getUserId(String username)
	{
		return mybatis.selectOne("user.select_user_id",username);
	}

}
