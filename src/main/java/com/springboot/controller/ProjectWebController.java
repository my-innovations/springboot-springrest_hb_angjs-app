package com.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectWebController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/")
	ModelAndView home(ModelAndView modelAndView) {
		log.debug("Inside home() : to load homepage");
		modelAndView.setViewName("home");
		return modelAndView;
	}
}