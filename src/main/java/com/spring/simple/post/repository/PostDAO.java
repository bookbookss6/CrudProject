package com.spring.simple.post.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.simple.page.vo.PageVO;
import com.spring.simple.post.vo.PostVO;

@Repository
public class PostDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<PostVO> getAllPosts(PageVO page)
	{
		return mybatis.selectList("post.select_all_posts",page);
	}
	
	public PostVO getPost(String postId)
	{
		return mybatis.selectOne("post.select_post",postId);
	}
	
	public void insertPost(PostVO post)
	{
		mybatis.insert("post.insert_post",post);
	}
	
	public void deletePost(int id)
	{
		mybatis.delete("post.delete_post", id);
	}
	
	public String getAuthor(int id)
	{
		return mybatis.selectOne("post.select_author",id);
	}
	public void updateVisited(PostVO post)
	{
		mybatis.update("post.update_visited", post);
	}
	
	public void updatePost(PostVO post)
	{
		mybatis.update("post.update_post", post);
	}
	
	public List<PostVO> getAllPostsWithKeyword(PageVO page)
	{
		return mybatis.selectList("post.select_all_posts_with_keyword",page);
	}

	public List<PostVO> getAllPosts(PageVO page , String loggedInUsername)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("loggedInUsername", loggedInUsername);
		map.put("maxSize", page.getMaxSize());
		map.put("offset", page.getOffset());
		
		return mybatis.selectList("post.select_all_posts_with_loggedInUsername",map);
	
	}
	
	public List<PostVO> getAllPostsWithKeyword(PageVO page , String loggedInUsername)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("loggedInUsername", loggedInUsername);
		map.put("keyword", page.getKeyword());
		map.put("maxSize", page.getMaxSize());
		map.put("offset", page.getOffset());
		
		return mybatis.selectList("post.select_all_posts_with_loggedInUsername_and_keyword",map);
	
	}
}
