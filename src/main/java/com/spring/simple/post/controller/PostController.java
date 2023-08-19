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
		// ���� �����ϱ�
		modelAndView.setViewName("redirect:/home?page=1&keyword=");
		
		String loggedInUsername = (String)request.getSession().getAttribute("loggedInUsername");

		// �����ϴ� �Խù��� �ش� �ۼ������� Ȯ��.
		if(loggedInUsername.equals(postService.getAuthor(postId)))
		{
			// �ش� �ۼ��ڰ� �ش� �Խù��� ������
			postService.deletePost(postId);
		}
		// �ƴϸ� ���� ó��
		else
		{
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter w = response.getWriter();
				w.write("<script>alert('�߸��� ���� �Դϴ�.'); location.href='/simple/home?page=1&keyword=';</script>");
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

		// ���� ���� �Ϸ��� �Խù��� �ۼ��ڰ� �ƴϸ� ���� ó�� �� �������� ���ư���.
		if(!author.equals(postService.getAuthor(postId)))
		{
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter w = response.getWriter();
				w.write("<script>alert('�߸��� ���� �Դϴ�.'); location.href='/simple/home?page=1&keyword='; </script>");
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
		
		// ���� ���� �Ϸ��� �Խù��� �ۼ��ڸ� �Խù� ����ó��.
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
				w.write("<script>alert('�߸��� ���� �Դϴ�.'); location.href='/simple/home?page=1&keyword='; </script>");
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
		
		// ���� �Ǵ� ���� �Ǵ� �ۼ��ڰ� ������� �� ���� ó����
		if(author == null || author.trim().equals("")||
		   title == null || title.trim().equals("")||
		   content == null || content.trim().equals(""))
		{
			
			
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter w = response.getWriter();
				w.write("<script>alert('����� ������ ��� �� �����ϴ�.'); location.href='/simple/post/create';</script>");
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
