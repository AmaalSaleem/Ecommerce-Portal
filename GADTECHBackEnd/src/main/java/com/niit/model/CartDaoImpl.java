package com.niit.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl
{
	@Autowired
	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public void insert(Cart cart)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
	}

	@SuppressWarnings({"unchecked","deprecation"})
	public List<Cart> FindCartById(String userId)
	{
		Session session=sessionFactory.openSession();
		List<Cart> cr=null;
		try
		{
			session.beginTransaction();
			cr=(List<Cart>)session.createQuery("From Cart where userMailID=email")
					.setString("email", userId).list();
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			session.getTransaction().rollback();
		}
		return cr;
	}
	
	public Cart getCartById(int catgId,String email)
	{
		Session session=sessionFactory.openSession();
		Cart cr=null;
		try
		{
			session.beginTransaction();
			cr=(Cart)session.createQuery("From Cart where userMailID =:email and cartProductId=:id")
					        .setString("email",email)
					        .setInteger("catgId", catgId)
					        .uniqueResult();
			session.getTransaction().commit();
			return cr;
		}
		catch(HibernateException e)
		{
			session.getTransaction().rollback();
		}
		return cr;
	}	
	
	public void deleteCart(int cartID)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Cart cr=(Cart)session.get(Cart.class, cartID);
		session.delete(cr);
		session.getTransaction().commit();
	}


}

