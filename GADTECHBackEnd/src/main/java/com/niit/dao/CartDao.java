package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDao 
{
	public boolean addCart(Cart cart);
    public boolean updateCart(Cart cart);
    public boolean deleteCart(Cart cart);
    public Cart getCartItem(int cartitemId); 
    public List<Cart> getCartItems(String username);
    public Cart getCartById(int pid,String userEmail);
}
