package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.CategoryDao;
import com.niit.model.Category;

public class CategoryTest 
{
	static CategoryDao categoryDAO;
	//@Ignore
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
        configApplnContext.scan("com.niit");
        configApplnContext.refresh();
         
        //SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
         
         categoryDAO = (CategoryDao)configApplnContext.getBean("categoryDao");
	}
	//@Ignore
		@Test
		public void addCategoryTest()
		{
			Category category=new Category();
			category.setCatgId(1001);
			category.setCatgName("Mobile");
			category.setCatgDescrip("redmi");
			assertTrue(categoryDAO.addCategory(category));
		}
		
		//@Ignore
		@Test
	    public void updateCategoryTest()
	    {
	        Category category=new Category();
	        category.setCatgId(1002);
	        category.setCatgName("JMShirt");
	        category.setCatgDescrip("John Miller Shirt with Best Price");
	         
	        assertTrue(categoryDAO.updateCategory(category));
	    }
		 @Ignore
		 @Test
		    public void deleteCategoryTest()
		    {
		        Category category=new Category();
		        category.setCatgId(1002);
		        assertTrue(categoryDAO.deleteCategory(category));
		    }
		    //@Ignore  
		    @Test
		    public void retrieveCategoryTest()
		    {
		        List<Category> listCategory=categoryDAO.retrieveCategory();
		        assertNotNull("Problem in Retriving ",listCategory);
		        this.show(listCategory);
		    }
		     
		    public void show(List<Category> listCategory)
		    {
		        for(Category category:listCategory)
		        {
		            System.out.println("Category ID:"+category.getCatgId());
		            System.out.println("Category Name:"+category.getCatgName());
		        }
		    }
		     
		    //@Ignore
		    @Test
		    public void getCategoryTest()
		    {
		        Category category=categoryDAO.getCategory(1002);
		        assertNotNull("Problem in Getting:",category);
		        System.out.println("Category ID:"+category.getCatgId());
		        System.out.println("Category Name:"+category.getCatgId());
		    }
		 

	

}
