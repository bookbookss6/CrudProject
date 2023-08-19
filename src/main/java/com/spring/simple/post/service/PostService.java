package com.spring.simple.post.service;

import java.util.List;

import com.spring.simple.page.vo.PageVO;
import com.spring.simple.post.vo.PostVO;

public interface PostService {

	List<PostVO> getAllPosts(PageVO page);
	PostVO getPost(String postId);
	void insertPost(PostVO post);
	void deletePost(int id);
	String getAuthor(int id);
	void updateVisited(PostVO post);
	void updatePost(PostVO post);
	List<PostVO> getAllPostsWithKeyword(PageVO page);
	List<PostVO> getAllPosts(PageVO page , String loggedInUsername);
	List<PostVO> getAllPostsWithKeyword(PageVO page , String loggedInUsername);
	
}
