package com.spring.simple.user.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.simple.user.service.UserSevice;
import com.spring.simple.user.vo.UserVO;

@Controller
public class SignupController {
	
	@Autowired
	private UserSevice userSevice;

	@RequestMapping(value = "/signup" , method = RequestMethod.GET)
	public ModelAndView signup(ModelAndView modelAndView)
	{
		modelAndView.setViewName("signup");
		return modelAndView;
	}
	
	@RequestMapping(value = "/signup.do" , method = RequestMethod.POST)
	public ModelAndView processSignup(ModelAndView modelAndView
									 ,HttpServletResponse response
									 ,@RequestParam Map<String,String> map
									 ,UserVO user)
	{
			
		modelAndView.setViewName("signup");
		user.setUsername(map.get("username"));
		user.setPassword(map.get("password"));
		
		String requestUsername = user.getUsername();
		String requestPassword = user.getPassword();

		// 빈 칸 입력 방지
		if(requestUsername == null || requestUsername.trim().equals("") ||
		   requestPassword == null || requestPassword.trim().equals(""))
		{
			modelAndView.addObject("errorMessage","회원 정보를 입력해주세요.");
			return modelAndView;
		}
		
		UserVO matchedUser = userSevice.getUser(requestUsername);
		
		// 존재한 유저이름이 있는지 확인
		if(matchedUser!=null)
		if(requestUsername.equalsIgnoreCase(matchedUser.getUsername()))
		{			
			modelAndView.addObject("errorMessage","이미 존재한 회원 입니다.");
			return modelAndView;
		}
	
		
		// 아무 이상 없으면 데이터베이스에 유저 정보 저장 후 alert()로 회원가입 완료창 띄우기
		userSevice.createUser(user);
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter w = response.getWriter();
			w.write("<script>alert('회원가입이 완료되었습니다.'); location.href='/simple/login';</script>");
			w.flush();
			w.close();
	    } catch(Exception e) {
			e.printStackTrace();
	    }
		
		return modelAndView;
	}
	
}
