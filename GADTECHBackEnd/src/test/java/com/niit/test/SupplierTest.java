package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Supplier;

public class SupplierTest 
{
	static SupplierDao supplierDAO;
//@Ignore
@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
    configApplnContext.scan("com.niit");
    configApplnContext.refresh();
     
   /* SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");*/
     
    supplierDAO = (SupplierDao)configApplnContext.getBean("supplierDao");
}
//@Ignore
@Test
public void addSupplierTest()
{
	Supplier supplier=new Supplier();
	supplier.setSplrId(103);
	supplier.setSplrName("xiomi");
	supplier.setSplrAddress("abcd");
	assertTrue(supplierDAO.addSupplier(supplier));
}
 

		//@Ignore
		@Test
	    public void updateSupplierTest()
	    {
			Supplier supplier=new Supplier();
			supplier.setSplrId(102);
	        supplier.setSplrName("supplier");
	        supplier.setSplrAddress("abcd");
	         
	        assertTrue(supplierDAO.updateSupplier(supplier));
	    }
		 //@Ignore
		 @Test
		    public void deleteCategoryTest()
		    {
			 Supplier supplier=new Supplier();
			 supplier.setSplrId(101);
			 assertTrue(supplierDAO.updateSupplier(supplier));
		    }
		    //@Ignore  
		    @Test
		    public void retrieveSupplierTest()
		    {
		        List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
		        assertNotNull("Problem in Retriving ",listSupplier);
		        this.show(listSupplier);
		    }
		     
		    public void show(List<Supplier> listSupplier)
		    {
		        for(Supplier supplier:listSupplier)
		        {
		            System.out.println("supplier ID:"+supplier.getSplrId());
		            System.out.println("supplier Name:"+supplier.getSplrName());
		        }
		    }
		     
		   //@Ignore
		    @Test
		    public void getSupplierTest()
		    {
		    	Supplier supplier=supplierDAO.getSupplier(103);
		        assertNotNull("Problem in Getting:",supplier);
		        System.out.println("Supplier ID:"+supplier.getSplrId());
		        System.out.println("Supplier Name:"+supplier.getSplrName());
		    }
		 





}

