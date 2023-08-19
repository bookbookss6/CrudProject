package com.spring.simple.post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.simple.comment.service.CommentService;
import com.spring.simple.comment.vo.CommentVO;
import com.spring.simple.post.service.PostService;
import com.spring.simple.post.vo.PostVO;
import com.spring.simple.user.service.UserSevice;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserSevice userSevice;
	
	@Autowired
	private CommentService commentService;
	
	
	@RequestMapping(value = "/post" , method = RequestMethod.GET)
	public ModelAndView post(ModelAndView modelAndView,HttpSession session
						   ,@RequestParam("id")int postId)
	{
		
		PostVO post = postService.getPost(Integer.toString(postId));			
		String imgStr = Base64.getEncoder().encodeToString(post.getImage());
		List<CommentVO> comments = commentService.getComments(postId);
		
		postService.updateVisited(post);
				
		modelAndView.setViewName("post");
		modelAndView.addObject("post",post);
		modelAndView.addObject("imgStr",imgStr);
		modelAndView.addObject("loggedInUsername",session.getAttribute("loggedInUsername"));
		modelAndView.addObject("commentAuthor",session.getAttribute("loggedInUsername"));
		modelAndView.addObject("comments",comments);
		
		return modelAndView;
	
	}
	
	@RequestMapping(value = "/post/delete" , method = RequestMethod.GET)
	public ModelAndView deletePost(ModelAndView modelAndView
								  ,HttpServletRequest request
								  ,HttpServletResponse response
								  ,@RequestParam("id")int postId)
	{
		// 삭제 구현하기
		modelAndView.setViewName("redirect:/home?page=1&keyword=");
		
		String loggedInUsername = (String)request.getSession().getAttribute("loggedInUsername");

		// 삭제하는 게시물이 해당 작성자인지 확인.
		if(loggedInUsername.equals(postService.getAuthor(postId)))
		{
			// 해당 작성자가 해당 게시물을 삭제함
			postService.deletePost(postId);
		}
		// 아니면 오류 처리
		else
		{
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter w = response.getWriter();
				w.write("<script>alert('잘못된 접근 입니다.'); location.href='/simple/home?page=1&keyword=';</script>");
				w.flush();
				w.close();
		    } catch(Exception e) {
				e.printStackTrace();
		    }
			
		}
	
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/post/update" , method = RequestMethod.GET)
	public ModelAndView updatePost(ModelAndView modelAndView
			  					  ,HttpServletRequest request
			  					  ,HttpServletResponse response
			  					  ,@RequestParam("id")int postId)
	{
		
		String author = (String) request.getSession().getAttribute("loggedInUsername");
		modelAndView.addObject("author",author);
		modelAndView.addObject("id",postId);
		modelAndView.setViewName("update-post");

		// 만약 수정 하려는 게시물의 작성자가 아니면 오류 처리 및 메인으로 돌아가기.
		if(!author.equals(postService.getAuthor(postId)))
		{
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter w = response.getWriter();
				w.write("<script>alert('잘못된 접근 입니다.'); location.href='/simple/home?page=1&keyword='; </script>");
				w.flush();
				w.close();
		    } catch(Exception e) {
				e.printStackTrace();
		    }
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/post/update.do" , method = RequestMethod.POST)
	public ModelAndView updatePost(ModelAndView modelAndView
								  ,HttpServletRequest request
								  ,HttpServletResponse response
								  ,@RequestParam("id")int postId
								  ,@RequestParam("author")String author
								  ,@RequestParam("title")String title
								  ,@RequestParam("content")String content
								  ,@RequestParam("image")MultipartFile image) throws IOException
	{
		modelAndView.setViewName("redirect:/post?id="+postId);
		
		// 만약 수정 하려는 게시물의 작성자면 게시물 수정처리.
		if(author.equals(postService.getAuthor(postId)))
		{
			PostVO post = new PostVO();
			post.setId(postId);
			post.setTitle(title);
			post.setContent(content);
			post.setImage(image.getBytes());
			
			postService.updatePost(post);
		}
		else
		{
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter w = response.getWriter();
				w.write("<script>alert('잘못된 접근 입니다.'); location.href='/simple/home?page=1&keyword='; </script>");
				w.flush();
				w.close();
		    } catch(Exception e) {
				e.printStackTrace();
		    }
		}
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/post/create" , method = RequestMethod.GET)
	public ModelAndView createPost(ModelAndView modelAndView
								  ,HttpServletRequest request)
	{
		
		String author = (String) request.getSession().getAttribute("loggedInUsername");
		modelAndView.addObject("author",author);
		modelAndView.setViewName("create-post");
		
		if(author == null)
		{
		
			modelAndView.setViewName("redirect:/home?page=1&keyword=");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/post/create.do" , method = RequestMethod.POST)
	public ModelAndView createPost(ModelAndView modelAndView
								 ,HttpServletResponse response
								 ,@RequestParam("author")String author
								 ,@RequestParam("title")String title
								 ,@RequestParam("content")String content
								 ,@RequestParam("image")MultipartFile image) throws IOException
	{
		
		modelAndView.setViewName("redirect:/home?page=1&keyword=");
		
		PostVO post = new PostVO();
		
		// 제목 또는 내용 또는 작성자가 비어있을 때 실패 처리함
		if(author == null || author.trim().equals("")||
		   title == null || title.trim().equals("")||
		   content == null || content.trim().equals(""))
		{
			
			
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter w = response.getWriter();
				w.write("<script>alert('제목과 내용을 비울 수 없습니다.'); location.href='/simple/post/create';</script>");
				w.flush();
				w.close();
		    } catch(Exception e) {
				e.printStackTrace();
		    }
			

		}
		else
		{
			post.setAuthor(author);
			post.setTitle(title);
			post.setContent(content);
			post.setImage(image.getBytes());
			post.setUserId(userSevice.getUserId(author));

			postService.insertPost(post);
		}
		
		return modelAndView;
	
	}
	
}
