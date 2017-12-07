package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.OrdersDao;
import com.niit.dao.ProductDao;
import com.niit.dao.UserDao;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Orders;
import com.niit.model.Product;
import com.niit.model.User;
@Controller
public class CartController 
{
	@Autowired
	CartDao cartDao;
	
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	@Autowired
	OrdersDao ordersDao;
	
	@RequestMapping(value="/addCart",method=RequestMethod.POST)
  	public ModelAndView goToaddCart(@RequestParam("pid")int pid, @RequestParam("qty")int qty)
  	{
  		
		ModelAndView mv=new ModelAndView();
  		Product p=productDao.getProduct(pid);
  		if(p.getStock()>=qty)
  		{
  		
  		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
  		String username = authentication.getName();
  		System.out.println("User Name : ---------------"+username);
  		
  		
  		
  		Cart c=cartDao.getCartById(pid,username);
  		
  		if(c==null)
  		{
  		c=new Cart();
  		c.setCartQnty(qty);
  		c.setProduct(p);
  		c.setCartUserDetails(userDao.getUser(username));
  		cartDao.addCart(c);
  		mv.addObject("status", "Product added to cart");
  		}
  		else
  		{
  			c.setCartQnty(c.getCartQnty()+qty);
  			cartDao.updateCart(c);
  			mv.addObject("status", "Cart Updated");
  		}
  		
  		
  		p.setStock(p.getStock()-qty);
  		productDao.updateProduct(p);
  	     mv.setViewName("redirect:/Cart");
  		
  		}
  		else
  		{
  			mv.setViewName("redirect:/productDescp");
  			mv.addObject("pid",pid);
  			mv.addObject("error", "Reqired no of products not available....");
  		}
  		
		return mv;
  	}
	

	@RequestMapping("/Cart")
  	public ModelAndView goToCart(@RequestParam("status") String status)
  	{
  		ModelAndView mv=new ModelAndView("Cart");
  		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
  		String username = authentication.getName();
  		
  		List<Category> cs=categoryDao.retrieveCategory();
  		mv.addObject("categoryList", cs);
  		
  		
  		System.out.println(cs);
  	    List<Cart> cartList=cartDao.getCartItems(username);
	    mv.addObject("cartInfo", cartList);
	    mv.addObject("status", status);
	    
	    
		
		return mv;
  	}
	
	@RequestMapping(value="deleteCart/{cartId}",method=RequestMethod.GET)
    public String deletemyCart(@PathVariable("cartId")int cartId,Model m)
    {
        Cart cart=cartDao.getCartItem(cartId);
        Product p=cart.getProduct();
        p.setStock(p.getStock()+cart.getCartQnty());
        productDao.updateProduct(p);
     
        
        cartDao.deleteCart(cart);
        Cart cartList=cartDao.getCartItem(cartId);
        m.addAttribute("cartList",cartList);
         
        Cart cart1=new Cart();
        m.addAttribute(cart1);
        m.addAttribute("status", "Cart item deleted Successfully");
         
        return "redirect:/Cart";
    }
	
	@RequestMapping(value="/updateCart",method=RequestMethod.POST)
    public String updateCart(@RequestParam("cid") int cartId,@RequestParam("qty") int qty,Model m)
    {
		Cart c=cartDao.getCartItem(cartId);
		/*System.out.println("Qty:-------------------------"+qty+"\nProduct Qty : "+c);*/
		if(c.getProduct().getStock()>=qty)
		{
		c.setCartQnty(qty);
		cartDao.updateCart(c);
		m.addAttribute("status", "");
		}
		else
		{
			m.addAttribute("status", "Not in Stock");
		}
		
		return "redirect:/Cart";
    }
	
	@RequestMapping("/Checkout")
  	public ModelAndView checkout()
  	{
  		ModelAndView mv=new ModelAndView("Checkout");
  		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		User u=userDao.getUser(username);
		mv.addObject("User", u);
  		List<Category> cs=categoryDao.retrieveCategory();
  		mv.addObject("categoryList", cs);
  		System.out.println(cs);
  	    List<Cart> cartList=cartDao.getCartItems(username);
	    mv.addObject("Cart", cartList);
	    
		
		return mv;
  	}
	
	@RequestMapping("/invoiceProcess")
  	public ModelAndView receiptGe(@RequestParam("total")int gtot,@RequestParam("name")String name, @RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("address")String address,@RequestParam("country")String country,@RequestParam("state")String state,@RequestParam("city")String city,@RequestParam("postalcode")String pincode)
  	{
  		ModelAndView mv=new ModelAndView("Invoice");
  		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		User u=userDao.getUser(username);
		mv.addObject("User", u);
		Orders o=new Orders();
		o.setGranttotal(gtot);
		o.setName(name);
		o.setAddress(address);
		o.setEmail(email);
		o.setPhone(phone);
		o.setState(state);
		o.setCity(city);
		o.setPincode(pincode);
		o.setUser(u);
		ordersDao.addOrders(o);
	
		
  		List<Category> cs=categoryDao.retrieveCategory();
  		mv.addObject("categoryList", cs);
  		System.out.println(cs);
  	    List<Cart> cartList=cartDao.getCartItems(username);
	    mv.addObject("Cart", cartList);
	    mv.addObject("Order", o);
	    
		
		return mv;
  	}
	@RequestMapping("/Ackorder")
  	public ModelAndView Ackorder()
  	{

  		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		List<Cart> clist=cartDao.getCartItems(username);
		
		for(Cart c: clist)
		{
		cartDao.deleteCart(c);
		}
		
		return new ModelAndView("Ackorder");
  	}
}
