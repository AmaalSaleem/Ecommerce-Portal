package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Controller
public class CategoryController 
{
	 @Autowired
	    CategoryDao categoryDAO;
	     
	     
	   @RequestMapping(value="AddCategory",method=RequestMethod.POST)
	    public String addCategory(@RequestParam("catgId") int catgId,@RequestParam("catgName") String catgName,@RequestParam("catgDescrip") String catgDescrip,Model m)
	    {
	        Category category=new Category();
	        category.setCatgId(catgId);
	        category.setCatgName(catgName);
	        category.setCatgDescrip(catgDescrip);
	         
	        categoryDAO.addCategory(category);
	         
	        List<Category> listCategory=categoryDAO.retrieveCategory();
	        m.addAttribute("categoryList",listCategory);
	         
	        return "Category";
	    }
	     
	   
	
}
