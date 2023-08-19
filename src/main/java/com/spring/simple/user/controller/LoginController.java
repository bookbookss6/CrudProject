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
		
		// �α��� ���¸� alert() ��� ���� home���� �̵�.
		if(session.getAttribute("loggedInUsername")!=null)
		{
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter w = response.getWriter();
				w.write("<script>alert('�̹� �α��� �����Դϴ�.'); location.href='/simple/home?page=1&keyword=';</script>");
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
		
		// �α��� ���¸� alert() ��� ���� home���� �̵�.
		if(session.getAttribute("loggedInUsername")!=null)
		{
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter w = response.getWriter();
				w.write("<script>alert('�̹� �α��� �����Դϴ�.'); location.href='/simple/home?page=1&keyword=';</script>");
				w.flush();
				w.close();
		    } catch(Exception e) {
				e.printStackTrace();
		    }
		}
		
		// �α��� ������ home.jsp �� �̵�.
		if(matchedUser != null && matchedUser.getPassword().equals(requestPassword))
		{
			session.setAttribute("loggedInUsername", requestUsername);
			modelAndView.setViewName("redirect:/home?page=1&keyword=");
		}
		
		// �α��� ���н� ���� �޽��� ���.
		else
		{
			modelAndView.setViewName("login");
			modelAndView.addObject("errorMessage", "���̵� , ��й�ȣ�� ��ġ ���� �ʽ��ϴ�.");
		}
		
		return modelAndView;
	}
	
}
