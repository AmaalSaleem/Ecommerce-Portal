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
	        m.addAttribute("status", "Category Added Successfully...");
	        return "redirect:/admin/category";

	    }
	   
	   @RequestMapping(value="/admin/category",method=RequestMethod.GET)
       public String showCategory(@RequestParam("status")String status,Model m)
       {
           Category category=new Category();
           m.addAttribute(category);
            
           List<Category> listCategory=categoryDAO.retrieveCategory();
           m.addAttribute("categoryList",listCategory);
           m.addAttribute("status", status);
           return "Category";
       }
	   
	   
	   @RequestMapping(value="admin/deleteCategory/{catgId}",method=RequestMethod.GET)
	    public String deleteCategory(@PathVariable("catgId")int catgId,Model m)
	    {
	        Category category=categoryDAO.getCategory(catgId);
	        
	        try
	        {
	        categoryDAO.deleteCategory(category);
	        m.addAttribute("status", "Category deleted Successfully...");
	        }
	        catch(Exception e)
	        {
	        	 m.addAttribute("status", "Some products already under this category...You cant delete this category..");
	        }
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
	        m.addAttribute("status", "Category Updated Successfully...");
	        return "redirect:/admin/category";
	    }
	     
	   
	     
	   
	
}
