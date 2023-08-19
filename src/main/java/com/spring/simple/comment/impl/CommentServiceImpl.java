package com.spring.simple.comment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.simple.comment.repository.CommentDAO;
import com.spring.simple.comment.service.CommentService;
import com.spring.simple.comment.vo.CommentVO;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public void insertComment(CommentVO comment) {
		commentDAO.insertComment(comment);
	}

	@Override
	public void deleteComment(int id) {
		commentDAO.deleteComment(id);
	}

	@Override
	public List<CommentVO> getComments(int postId) {
		return commentDAO.selectComments(postId);
	}

	@Override
	public CommentVO getComment(int id) {
		return commentDAO.selectComment(id);
	}

}
