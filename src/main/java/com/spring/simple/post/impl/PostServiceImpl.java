package com.spring.simple.post.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.simple.page.vo.PageVO;
import com.spring.simple.post.repository.PostDAO;
import com.spring.simple.post.service.PostService;
import com.spring.simple.post.vo.PostVO;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostDAO postDao;
	
	@Override
	public List<PostVO> getAllPosts(PageVO page) {
		
		return postDao.getAllPosts(page);
	}

	@Override
	public PostVO getPost(String postId) {
		return postDao.getPost(postId);
	}

	@Override
	public void insertPost(PostVO post) {
		postDao.insertPost(post);
	}

	@Override
	public void deletePost(int id) {
		postDao.deletePost(id);
	}

	@Override
	public String getAuthor(int id) {
		return postDao.getAuthor(id);
	}

	@Override
	public void updateVisited(PostVO post) {
		postDao.updateVisited(post);
	}

	@Override
	public void updatePost(PostVO post) {
		postDao.updatePost(post);
	}

	@Override
	public List<PostVO> getAllPostsWithKeyword(PageVO page) {
		return postDao.getAllPostsWithKeyword(page);
	}

	@Override
	public List<PostVO> getAllPosts(PageVO page, String loggedInUsername) {
		return postDao.getAllPosts(page, loggedInUsername);
	}

	@Override
	public List<PostVO> getAllPostsWithKeyword(PageVO page, String loggedInUsername) {
		return postDao.getAllPostsWithKeyword(page, loggedInUsername);
	}

}
