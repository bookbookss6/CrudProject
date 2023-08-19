package com.spring.simple.user.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.simple.user.service.UserSevice;
import com.spring.simple.user.vo.UserVO;

@Controller
public class LoginController {
	
	@Autowired
	private UserSevice userSevice;

	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public ModelAndView login(ModelAndView modelAndView
							 ,HttpServletRequest request
							 ,HttpServletResponse response)
	{

		HttpSession session = request.getSession();
		
		// 로그인 상태면 alert() 출력 띄우고 home으로 이동.
		if(session.getAttribute("loggedInUsername")!=null)
		{
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter w = response.getWriter();
				w.write("<script>alert('이미 로그인 상태입니다.'); location.href='/simple/home?page=1&keyword=';</script>");
				w.flush();
				w.close();
		    } catch(Exception e) {
				e.printStackTrace();
		    }
		}
		
		modelAndView.setViewName("login");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/login.do" , method = RequestMethod.POST)
	public ModelAndView processLogin(ModelAndView modelAndView
									,@RequestParam Map<String,String> map
									,HttpServletRequest request
									,HttpServletResponse response)
	{	
		
		String requestUsername = map.get("username");
		String requestPassword = map.get("password");
		
		UserVO matchedUser = userSevice.getUser(requestUsername);
		HttpSession session = request.getSession();
		
		// 로그인 상태면 alert() 출력 띄우고 home으로 이동.
		if(session.getAttribute("loggedInUsername")!=null)
		{
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter w = response.getWriter();
				w.write("<script>alert('이미 로그인 상태입니다.'); location.href='/simple/home?page=1&keyword=';</script>");
				w.flush();
				w.close();
		    } catch(Exception e) {
				e.printStackTrace();
		    }
		}
		
		// 로그인 성공시 home.jsp 로 이동.
		if(matchedUser != null && matchedUser.getPassword().equals(requestPassword))
		{
			session.setAttribute("loggedInUsername", requestUsername);
			modelAndView.setViewName("redirect:/home?page=1&keyword=");
		}
		
		// 로그인 실패시 에러 메시지 출력.
		else
		{
			modelAndView.setViewName("login");
			modelAndView.addObject("errorMessage", "아이디 , 비밀번호가 일치 하지 않습니다.");
		}
		
		return modelAndView;
	}
	
}
