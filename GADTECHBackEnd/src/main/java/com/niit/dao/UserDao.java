package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDao 
{
	public boolean insertUser(User user);
	public List<User> retrieveUser(); 
	public User getUser(String username);

}
