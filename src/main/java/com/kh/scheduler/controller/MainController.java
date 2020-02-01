package com.kh.scheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller 
public class MainController {
	
	@ApiIgnore
	@RequestMapping("/main")
	public String mainPage() {
		return "main";
	}
	
	@ApiIgnore
	@RequestMapping("/signup")
	public String signupPage() {
		return "signup";
	}
	
}
