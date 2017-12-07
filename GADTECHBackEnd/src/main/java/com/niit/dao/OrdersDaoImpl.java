package com.niit.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Orders;
@Repository("OrderDao")
public class OrdersDaoImpl implements OrdersDao
{
	
	 @Autowired
	 SessionFactory sessionFactory;
	 
	 
	@Transactional
	public boolean addOrders(Orders order)
	{
		
		 try
	        {
	            sessionFactory.getCurrentSession().save(order);
	            return true;
	        }
	        catch(Exception e)
	        {
	            return false;
	        }
	}

}
