package com.niit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController 
{
	@RequestMapping("/")
	public String index()
	{
		return "Index";
	}
	@RequestMapping("/register")
	public String reg()
	{
		return "Registration";
	}

	@RequestMapping("/category")
	public String catg()
	{
		return "Category";
	}
	@RequestMapping("/supplier")
	public String supplr()
	{
		return "Supplier";
	}
	@RequestMapping("/login")
	public String login()
	{
		return "Login";
	}

}
