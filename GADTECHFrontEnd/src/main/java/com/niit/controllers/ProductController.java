package com.niit.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Product;

@Controller
public class ProductController 
{
	 @Autowired
	    ProductDao productDAO;
	     
	    @Autowired
	    CategoryDao categoryDao;
	    

	    @Autowired
	    SupplierDao supplierDao;
	     
	    @RequestMapping(value="/admin/product",method=RequestMethod.GET)
	    public String showProduct(Model m)
	    {
	       
	        m.addAttribute("categoryList",categoryDao.retrieveCategory());
	        m.addAttribute("supplierList",supplierDao.retrieveSupplier());
	        List<Product> listProducts=productDAO.retrieveProduct();
	        m.addAttribute("productList",listProducts);
	        return "Product";
	    }
	   	    @RequestMapping(value="/admin/InsertProduct",method=RequestMethod.POST)
	    public String insertProduct(@RequestParam("productName") String productName,@RequestParam("productDesc") String productDesc,@RequestParam("stock") int stock,@RequestParam("sup") int sid,@RequestParam("cat") int cid,@RequestParam("price") int price,@RequestParam("pimage")MultipartFile fileDetail,Model m)
	    {
	         
	        Product p=new Product();
	        p.setProductName(productName);
	        p.setPrice(price);
	        p.setProductDesc(productDesc);
	        p.setStock(stock);
	        p.setCategory(categoryDao.getCategory(cid));
	        p.setSupplier(supplierDao.getSupplier(sid));
	        p.setPimage(fileDetail);
	        
	        productDAO.addProduct(p);
	        
	   	    	
	   	    	
	   	    	
	        String path="E:/ECOM-PORT/GADTECHFrontEnd/src/main/webapp/resources/";
	         
	        String totalFileWithPath=path+String.valueOf(p.getProductId())+".jpg";
	         
	        File productImage=new File(totalFileWithPath);
	         
	        if(!fileDetail.isEmpty())
	        {
	            try
	            {
	                byte fileBuffer[]=fileDetail.getBytes();
	                FileOutputStream fos=new FileOutputStream(productImage);
	                BufferedOutputStream bs=new BufferedOutputStream(fos);
	                bs.write(fileBuffer);
	                bs.close();
	            }
	            catch(Exception e)
	            {
	                m.addAttribute("error",e.getMessage());
	            }
	        }
	        else
	        {
	            m.addAttribute("error","Problem in File Uploading");
	        }
	         
	        Product product1=new Product();
	        m.addAttribute(product1);
	         
	        return "redirect:/admin/product";
	    }
	     
	    
	    @RequestMapping(value="admin/productDesc/{productId}")
	    public String showProductDesc(@PathVariable("productId")int productId,Model m)
	    {
	        Product product=productDAO.getProduct(productId);
	        m.addAttribute("product",product);
	        return "ProductDesc";
	    }
	    
	    @RequestMapping(value="admin/deleteProduct/{productId}",method=RequestMethod.GET)
	    public String deleteProduct(@PathVariable("productId")int productId,Model m)
	    {
	        Product product=productDAO.getProduct(productId);
	        productDAO.deleteProduct(product);
	        List<Product> listProduct=productDAO.retrieveProduct();
	        m.addAttribute("productList",listProduct);
	         
	        Product product1= new Product();
	        m.addAttribute(product1);
	         
	        return "redirect:/admin/product";
	    }
	    
	    @RequestMapping(value="admin/updateP",method=RequestMethod.GET)
	    public String updateProduct(@RequestParam("productId") int productId,Model m)
	    {
	    	Product product=productDAO.getProduct(productId);
	    	m.addAttribute("prod",product);
	    	m.addAttribute("categoryList",categoryDao.retrieveCategory());
		    m.addAttribute("supplierList",supplierDao.retrieveSupplier());
	    	
	    	List<Product> listProduct=productDAO.retrieveProduct();
		    m.addAttribute("productList",listProduct);
		    
		    return "UpdateProduct";
	    }
	    
	    
	    @RequestMapping(value="/productList",method=RequestMethod.GET)
	    public String productListByCat(@RequestParam("cid") int cId,Model m)
	    {
	    	
	    	
	    	m.addAttribute("categoryList",categoryDao.retrieveCategory());
	    	
	    	List<Product> listProduct=productDAO.retrieveProductByCat(cId);
		    m.addAttribute("productList",listProduct);
		    
		    return "ProductByCid";
	    }
	    
	    
	    @RequestMapping(value="/admin/updateProduct",method=RequestMethod.POST)
	    public String newUpdateProd(@RequestParam("productId") int productId,@RequestParam("productName") String productName,@RequestParam("productDesc") String productDesc,@RequestParam("stock") int stock,@RequestParam("sup") int sid,@RequestParam("cat") int cid,@RequestParam("price") int price,@RequestParam("pimage")MultipartFile fileDetail,Model m)
	    {
	    	Product p=productDAO.getProduct(productId);
	    	p.setProductId(productId);
	        p.setProductName(productName);
	        p.setPrice(price);
	        p.setProductDesc(productDesc);
	        p.setStock(stock);
	        p.setCategory(categoryDao.getCategory(cid));
	        p.setSupplier(supplierDao.getSupplier(sid));
	        p.setPimage(fileDetail);
	        
	        productDAO.updateProduct(p);
	        
	   	    	
	   	    	
	   	    	
	        String path="E:/ECOM-PORT/GADTECHFrontEnd/src/main/webapp/resources/";
	         
	        String totalFileWithPath=path+String.valueOf(p.getProductId())+".jpg";
	         
	        File productImage=new File(totalFileWithPath);
	         
	        if(!fileDetail.isEmpty())
	        {
	            try
	            {
	                byte fileBuffer[]=fileDetail.getBytes();
	                FileOutputStream fos=new FileOutputStream(productImage);
	                BufferedOutputStream bs=new BufferedOutputStream(fos);
	                bs.write(fileBuffer);
	                bs.close();
	            }
	            catch(Exception e)
	            {
	                m.addAttribute("error",e.getMessage());
	            }
	        }
	        else
	        {
	            m.addAttribute("error","Problem in File Uploading");
	        }
	         
	        Product product1=new Product();
	        m.addAttribute(product1);
	         
	        return "redirect:/product";
	    }
}
