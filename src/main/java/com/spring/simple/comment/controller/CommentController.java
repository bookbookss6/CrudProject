package com.spring.simple.comment.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.simple.comment.service.CommentService;
import com.spring.simple.comment.vo.CommentVO;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/comment.do" ,method = RequestMethod.POST)
	public ModelAndView postComment(ModelAndView modelAndView
								  ,HttpServletResponse response
								  ,@RequestParam("commentAuthor")String author
								  ,@RequestParam("postId")int postId
								  ,@RequestParam("content")String content)
	{
		
		CommentVO comment = new CommentVO();
		comment.setAuthor(author);
		comment.setPostId(postId);
		comment.setContent(content);
		
		modelAndView.setViewName("redirect:/post?id="+postId);
		
		// 글 작성자가 없으면 오류 처리
		if(author == null)
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
		else
		{
			commentService.insertComment(comment);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/comment/delete" ,method = RequestMethod.GET)
	public ModelAndView deleteComment(ModelAndView modelAndView
									 ,HttpServletRequest request
									 ,HttpServletResponse response
									 ,@RequestParam("id")int commentId)
	{
		String loggedInUsername = (String)request.getSession().getAttribute("loggedInUsername");
		
		CommentVO comment = commentService.getComment(commentId);
		modelAndView.setViewName("redirect:/post?id="+comment.getPostId());
		
		if(comment.getAuthor().equals(loggedInUsername))
		{
			commentService.deleteComment(commentId);
		}
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
}
