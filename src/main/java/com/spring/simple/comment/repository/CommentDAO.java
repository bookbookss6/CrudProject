package com.spring.simple.comment.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.simple.comment.vo.CommentVO;

@Repository
public class CommentDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertComment(CommentVO comment)
	{
		mybatis.insert("comment.insert_comment", comment);
	}
	
	public void deleteComment(int id)
	{
		mybatis.delete("comment.delete_comment",id);
	}
	
	public List<CommentVO> selectComments(int postId)
	{
		return mybatis.selectList("comment.select_comments",postId);
	}
	
	public CommentVO selectComment(int id)
	{
		return mybatis.selectOne("comment.select_comment",id);
	}
}
