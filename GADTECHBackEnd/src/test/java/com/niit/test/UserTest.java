package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.User;

public class UserTest 
{
	static UserDao userDAO;

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
	    configApplnContext.scan("com.niit");
	    configApplnContext.refresh();
	     
	   /* SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");*/
	     
	    userDAO =(UserDao) configApplnContext.getBean("userDao");
	}

			//@Ignore
			@Test
			public void InsertUserTest()
			{
				User user=new User();
				user.setName("devika");
				user.setEmail("devika@gmail.com");
				user.setAddress("vakkulathil");
				user.setPhone("899651");
				user.setCountry("india");
				user.setPassword("amal1811");
				user.setRole("ncbhd");
				user.setEnabled(true);
				
				assertTrue(userDAO.insertUser(user));
			}
			@Ignore
			 @Test
			    public void retrieveUserTest()
			    {
			        List<User> listUser=userDAO.retrieveUser();
			        assertNotNull("Problem in Retriving ",listUser);
			        this.show(listUser);
			    }

			private void show(List<User> listUser) 
			{
				 for(User user:listUser)
			        {
			            System.out.println("User Email ID:"+user.getEmail());
			            System.out.println("User Name:"+user.getName());
			        }
				
			}

}
