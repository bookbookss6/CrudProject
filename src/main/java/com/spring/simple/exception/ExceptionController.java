package com.spring.simple.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

	@GetMapping("/error/{status-code}")
	public ModelAndView errorPage(@PathVariable("status-code") String statusCode)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("statusCode",statusCode);
		modelAndView.setViewName("error");
		return modelAndView;
	}
	
}
