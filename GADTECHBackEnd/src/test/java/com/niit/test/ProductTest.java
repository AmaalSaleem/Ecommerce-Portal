package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

public class ProductTest 
{
	
	@Autowired
	static ProductDao productDao;
    
	 //@Ignore
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();
		//SessionFactory sessioFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		productDao=(ProductDao)configApplnContext.getBean("productDao");

	}
	@Ignore
	@Test
	public void addProductTest() 
	{
		Product product=new Product();
		product.setProductId(4);
		product.setProductName("food");
		product.setProductDesc("yammy food");
		product.setStock(10);
		product.setPrice(800);
		product.setCategory(new Category());
		product.setSupplier(new Supplier());
		assertTrue("Problem in insertion",productDao.addProduct(product));

	}
	
	
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=new Product();
		product.setProductId(3);
		product.setProductName("JMShirt");
		product.setProductDesc("John Miller Shirt with Best Price");
		product.setStock(10);
		product.setPrice(800);
		product.setCategory(new Category());
		
		assertTrue(productDao.updateProduct(product));
	}
	
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=new Product();
		product.setProductId(3);
		assertTrue(productDao.deleteProduct(product));
	}
	
	@Ignore
	@Test
	public void retrieveProductTest()
	{
		List<Product> listProduct=productDao.retrieveProduct();
		assertNotNull("Problem in Retrieving ",listProduct);
		this.show(listProduct);
	}
	
	public void show(List<Product> listProduct)
	{
		for(Product product:listProduct)
		{
			System.out.println("Product ID:"+product.getProductId());
			System.out.println("Product Name:"+product.getProductName());
			System.out.println("Product Description:"+product.getProductDesc());
		}
	}
	
	@Ignore
	@Test
	public void getCategoryTest()
	{
		Product product=productDao.getProduct(4);
		assertNotNull("Problem in Getting:",product);
		System.out.println("Category ID:"+product.getProductId());
		System.out.println("Category Name:"+product.getProductName());
	}

}
