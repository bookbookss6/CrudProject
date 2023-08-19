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

		// �� ĭ �Է� ����
		if(requestUsername == null || requestUsername.trim().equals("") ||
		   requestPassword == null || requestPassword.trim().equals(""))
		{
			modelAndView.addObject("errorMessage","ȸ�� ������ �Է����ּ���.");
			return modelAndView;
		}
		
		UserVO matchedUser = userSevice.getUser(requestUsername);
		
		// ������ �����̸��� �ִ��� Ȯ��
		if(matchedUser!=null)
		if(requestUsername.equalsIgnoreCase(matchedUser.getUsername()))
		{			
			modelAndView.addObject("errorMessage","�̹� ������ ȸ�� �Դϴ�.");
			return modelAndView;
		}
	
		
		// �ƹ� �̻� ������ �����ͺ��̽��� ���� ���� ���� �� alert()�� ȸ������ �Ϸ�â ����
		userSevice.createUser(user);
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter w = response.getWriter();
			w.write("<script>alert('ȸ�������� �Ϸ�Ǿ����ϴ�.'); location.href='/simple/login';</script>");
			w.flush();
			w.close();
	    } catch(Exception e) {
			e.printStackTrace();
	    }
		
		return modelAndView;
	}
	
}
