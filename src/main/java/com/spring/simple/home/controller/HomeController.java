package com.spring.simple.home.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.simple.page.vo.PageVO;
import com.spring.simple.post.service.PostService;
import com.spring.simple.post.vo.PostVO;
import com.spring.simple.user.service.UserSevice;
import com.spring.simple.utils.PageContainerUtils;
import com.spring.simple.utils.PageVOUtils;

@Controller
public class HomeController {
	
	@Autowired
	private PostService postService;

	@Autowired
	private UserSevice userService;
	
	@RequestMapping(value = "/home" ,method = RequestMethod.GET)
	public ModelAndView home(ModelAndView modelAndView
							,HttpServletRequest request
							,@RequestParam("page")int page
							,@RequestParam("keyword")String keyword) throws Exception
	{	
	
		
		PageVO pageVO = PageVOUtils.initByCurrentPage(page);
		
		List<PostVO> posts = null;
		if(keyword!=null && !keyword.trim().equals(""))
		{
			pageVO.setKeyword(keyword);
			posts = postService.getAllPostsWithKeyword(pageVO);
		}
		else
		{
			posts =  postService.getAllPosts(pageVO);
		}
	
		String loggedInUsername = (String) request.getSession().getAttribute("loggedInUsername");
		
		modelAndView.setViewName("home");
		modelAndView.addObject("posts",posts);
		modelAndView.addObject("page",page);
		modelAndView.addObject("keyword",keyword);
		modelAndView.addObject("linkPages",PageContainerUtils.getLinkPages(page));
			
		if(loggedInUsername!=null)
		{
			modelAndView.addObject("loggedInUsername",loggedInUsername);
		}
		

		return modelAndView;
	}
	
	
	@RequestMapping(value = "/home/{loggedInUsername}" ,method = RequestMethod.GET)
	public ModelAndView home(ModelAndView modelAndView
							,HttpServletRequest request
							,HttpServletResponse response
							,@RequestParam("page")int page
							,@RequestParam("keyword")String keyword
							,@PathVariable("loggedInUsername")String loggedInUsername) throws Exception
	{	

		// 해당 로그인유저의 프로파일이 아니면 오류 처리
		if(!loggedInUsername.equals((String)request.getSession().getAttribute("loggedInUsername")))
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
		
		
		PageVO pageVO = PageVOUtils.initByCurrentPage(page);
		
		List<PostVO> posts = null;
		if(keyword!=null && !keyword.trim().equals(""))
		{
			pageVO.setKeyword(keyword);
			posts = postService.getAllPostsWithKeyword(pageVO,loggedInUsername);
		}
		else
		{
			posts =  postService.getAllPosts(pageVO, loggedInUsername);
		}
	
		
		modelAndView.setViewName("show-user-post");
		modelAndView.addObject("posts",posts);
		modelAndView.addObject("page",page);
		modelAndView.addObject("keyword",keyword);
		modelAndView.addObject("linkPages",PageContainerUtils.getLinkPages(page));
			
		if(loggedInUsername!=null)
		{
			modelAndView.addObject("loggedInUsername",loggedInUsername);
		}
		

		return modelAndView;
	}
	
}
