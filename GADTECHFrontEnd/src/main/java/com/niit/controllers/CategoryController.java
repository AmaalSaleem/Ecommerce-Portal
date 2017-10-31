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
	     
	     
	   @RequestMapping(value="/admin/AddCategory",method=RequestMethod.POST)
	    public String addCategory(@RequestParam("catgName") String catgName,@RequestParam("catgDescrip") String catgDescrip,Model m)
	    {
	        Category category=new Category();
	        category.setCatgName(catgName);
	        category.setCatgDescrip(catgDescrip);
	         
	        categoryDAO.addCategory(category);
	         
	        List<Category> listCategory=categoryDAO.retrieveCategory();
	        m.addAttribute("categoryList",listCategory);
	         
	        return "redirect:/admin/category";

	    }
	   
	   @RequestMapping(value="/admin/category",method=RequestMethod.GET)
       public String showCategory(Model m)
       {
           Category category=new Category();
           m.addAttribute(category);
            
           List<Category> listCategory=categoryDAO.retrieveCategory();
           m.addAttribute("categoryList",listCategory);
           return "Category";
       }
	   
	   
	   @RequestMapping(value="admin/deleteCategory/{catgId}",method=RequestMethod.GET)
	    public String deleteCategory(@PathVariable("catgId")int catgId,Model m)
	    {
	        Category category=categoryDAO.getCategory(catgId);
	        categoryDAO.deleteCategory(category);
	        List<Category> listCategory=categoryDAO.retrieveCategory();
	        m.addAttribute("categoryList",listCategory);
	         
	        Category category1=new Category();
	        m.addAttribute(category1);
	         
	        return "redirect:/admin/category";
	    }
	   
	   
	   @RequestMapping(value="admin/updateC",method=RequestMethod.GET)
	    public String updateCategory(@RequestParam("catgId") int catgId,Model m)
	    {
	        Category category=categoryDAO.getCategory(catgId);
	        m.addAttribute("cat",category);
	         
	        List<Category> listCategory=categoryDAO.retrieveCategory();
	        m.addAttribute("categoryList",listCategory);
	        return "UpdateCategory";
	    }
	   
	   @RequestMapping(value="/admin/updateCategory",method=RequestMethod.POST)
	    public String updateNewCatg(@RequestParam("catgId") int catgId,@RequestParam("catgName") String catgName,@RequestParam("catgDescrip") String catgDescrip,Model m)
	    {
		   Category category=categoryDAO.getCategory(catgId);
	        category.setCatgName(catgName);
	        category.setCatgDescrip(catgDescrip);
	         
	        categoryDAO.updateCategory(category);
	         
	        List<Category> listCategory=categoryDAO.retrieveCategory();
	        m.addAttribute("categoryList",listCategory);
	         
	        return "redirect:/admin/category";
	    }
	     
	   
	     
	   
	
}
