package com.spring.simple.comment.service;

import java.util.List;

import com.spring.simple.comment.vo.CommentVO;

public interface CommentService {
	
	void insertComment(CommentVO comment);
	void deleteComment(int id);
	List<CommentVO> getComments(int postId);
	CommentVO getComment(int id);
	
}
