package com.spring.simple.profile.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.simple.user.service.UserSevice;

@Controller
public class ProfileController {

	@Autowired
	private UserSevice userSevice;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile(ModelAndView modelAndView
							   ,HttpServletRequest request
							   )
	{
		
		HttpSession session = request.getSession();

		String loggedInUsername = (String)session.getAttribute("loggedInUsername");
		
		if(loggedInUsername == null)
		{
			modelAndView.setViewName("redirect:/home?page=1&keyword=");
			return modelAndView;
		}
		
		modelAndView.setViewName("profile");
		modelAndView.addObject("loggedInUsername",loggedInUsername);
		
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/profile/delete", method = RequestMethod.GET)
	public ModelAndView deleteProfile(ModelAndView modelAndView
									 ,HttpServletRequest request
									 ,@RequestParam("username") String loggedInUsername
			   )
	{
		
		modelAndView.setViewName("redirect:/login");
		HttpSession session = request.getSession();
		session.invalidate();
		
		userSevice.deleteUser(loggedInUsername);
		
		return modelAndView;
	}
}
