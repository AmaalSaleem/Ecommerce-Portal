package com.niit.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDaoImpl;
import com.niit.dao.ProductDaoImpl;
import com.niit.dao.SupplierDaoImpl;
import com.niit.dao.UserDaoImpl;
import com.niit.model.Cart;
import com.niit.model.CartDaoImpl;
import com.niit.model.Product;

@Controller
public class CartController
{
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	CartDaoImpl cartDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	
	@RequestMapping(value="/productDetails{cid}")
	public ModelAndView proDet(@PathVariable("cid") int cid)
	{
		ModelAndView mv=new ModelAndView();
		Product p= productDaoImpl.findById(cid);
		mv.addObject("product", p);
		mv.setViewName("productDetails");
		return mv;
	}
	
	
	
	@RequestMapping(value="/addToCart", method=RequestMethod.POST)
	public ModelAndView addToCart(HttpServletRequest req)
	{
		Principal principal=req.getUserPrincipal();
		String userEmail=principal.getName();
		try
		{
			int productId=Integer.parseInt(req.getParameter("productId"));
			Double price=Double.parseDouble(req.getParameter("price"));
			int quantity=Integer.parseInt(req.getParameter("stock"));
			String cartproductName=req.getParameter("cartProdName");
			String imgName=req.getParameter("imgName");
			Cart cartexit=cartDaoImpl.getCartById(productId, userEmail);
			
			
			if (cartexit==null)
			{
				Cart ct= new Cart(S);
				cm.
				
			}
			
		}
	}
	

}
