package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Cart;

@Repository("cartDao")
@EnableTransactionManagement
public class CartDaoImpl implements CartDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public Cart getCartById(int pid,String userEmail)
	{
		Session session=sessionFactory.openSession();
		Cart cr=null;
		try
		{
			System.out.println("===========Product existence============="+cr);
			session.beginTransaction();
			cr=(Cart)session.createQuery("From Cart where USERMAILID =:email and PRODUCT_ID=:id")
					        .setString("email",userEmail)
					        .setInteger("id", pid)
					        .uniqueResult();
			session.getTransaction().commit();
			System.out.println("Cart: "+cr);
			return cr;
		}
		catch(HibernateException e)
		{
			System.out.println("===========ERROR============="+e.getMessage());
			session.getTransaction().rollback();
		}
		return cr;
	}	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Cart> getCartItems(String username) {
        Session session=sessionFactory.openSession();
        List<Cart> cr=null;
        try
        {
            session.beginTransaction();
             
            cr=(List<Cart>)session.createQuery("From Cart where USERMAILID='"+username+"'").list();
            session.getTransaction().commit();
        }
        catch(HibernateException e)
        {
            session.getTransaction().rollback();
        }
        return cr;
    }


	@Transactional
	public boolean addCart(Cart cart) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
		return true;
	}

	@Transactional
	public boolean updateCart(Cart cart) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(cart);
		session.getTransaction().commit();
		return true;
	}

	@Transactional
	public boolean deleteCart(Cart cart) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(cart);
		session.getTransaction().commit();
		return true;
	}


	public Cart getCartItem(int cartitemId) 
	{
		 Session session=sessionFactory.openSession();
	        Cart cart=(Cart)session.get(Cart.class, cartitemId);
	        session.close();
	        return cart;
	}

}

