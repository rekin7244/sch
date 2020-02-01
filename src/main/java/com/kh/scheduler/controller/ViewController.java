package com.kh.scheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class ViewController {
	
	@RequestMapping("/main")
	public String mainPage() {
		return "main";
	}
	
	@RequestMapping("/signup")
	public String signupPage() {
		return "signup";
	}
	
	@RequestMapping("/todoMain")
	public String todoPage() {
		return "todo";
	}
	
}
