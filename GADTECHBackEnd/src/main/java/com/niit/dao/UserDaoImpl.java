package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.niit.model.User;

@Repository("userDao")
@EnableTransactionManagement
public class UserDaoImpl implements UserDao
{
	@Autowired
	SessionFactory sessionfactory;
	@Transactional

	public boolean insertUser(User user)
	{
		try
		{
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			session.persist(user);
			session.getTransaction().commit();
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
			
	}

	public List<User> retrieveUser() 
	{
		Session session=sessionfactory.openSession();
        Query query=session.createQuery("from User");
        List<User> listUser=query.list();
        session.close();
        return listUser;
		
	}

}
