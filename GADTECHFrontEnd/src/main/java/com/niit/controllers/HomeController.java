package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.CategoryDao;
@Controller
public class HomeController 
{
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/")
	public String index(Model m)
	{
        m.addAttribute("categoryList",categoryDao.retrieveCategory());
		return "Index";
	}
	@RequestMapping("/admin")
	public String indexAdmin(Model m)
	{
        m.addAttribute("categoryList",categoryDao.retrieveCategory());
		return "Index";
	}
	@RequestMapping("/register")
	public String reg(Model m)
	{
		m.addAttribute("categoryList",categoryDao.retrieveCategory());
		return "Registration";
	}

	@RequestMapping("/login")
	public String login(Model m)
	{
		m.addAttribute("categoryList",categoryDao.retrieveCategory());
		return "Login";
	}

	

}
