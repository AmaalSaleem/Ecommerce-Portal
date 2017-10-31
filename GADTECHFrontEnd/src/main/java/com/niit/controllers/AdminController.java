package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
@Controller
public class AdminController
{
	@Autowired
    ProductDao productDAO;
     
    @Autowired
    CategoryDao categoryDao;
    

    @Autowired
    SupplierDao supplierDao;
	@RequestMapping("/admin/adding")
	public ModelAndView adding()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Adding");
		mv.addObject("categoryList",categoryDao.retrieveCategory());
	    mv.addObject("supplierList",supplierDao.retrieveSupplier());
		return mv;
		
	}
	@RequestMapping("/adding")
	public ModelAndView addingA()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/admin/adding");
		return mv;
		
	}
}
