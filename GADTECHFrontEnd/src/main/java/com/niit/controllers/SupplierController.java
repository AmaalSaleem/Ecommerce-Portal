package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Supplier;


@Controller 
public class SupplierController 
{ 
	@Autowired
	SupplierDao supplierDAO;
	
	
	 @RequestMapping(value="/admin/AddSupplier",method=RequestMethod.POST)
	   public String addSupplier(@RequestParam("splrName") String splrName,@RequestParam("splrAdd") String splrAddress,Model m)
	   {
		 Supplier supplier=new Supplier();
		 supplier.setSplrName(splrName);
		 supplier.setSplrAddress(splrAddress);
	    
		 supplierDAO.addSupplier(supplier);
	         
	        List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
	        m.addAttribute("SupplierList",listSupplier);
	        return "redirect:/admin/supplier";
	   }
	 @RequestMapping(value="/admin/supplier",method=RequestMethod.GET)
     public String showSupplier(Model m)
     {
         Supplier supplier=new Supplier();
         m.addAttribute(supplier);
          
         List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
         m.addAttribute("supplierList",listSupplier);
         return "Supplier";
     }
	 
	 @RequestMapping(value="admin/deleteSupplier/{splrId}",method=RequestMethod.GET)
	    public String deleteSupplier(@PathVariable("splrId")int splrId,Model m)
	    {
		 Supplier supplier=supplierDAO.getSupplier(splrId);
		 supplierDAO.deleteSupplier(supplier);
	        List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
	        m.addAttribute("supplierList",listSupplier);
	         
	        Supplier supplier1=new Supplier();
	        m.addAttribute(supplier1);
	         
	        return "redirect: /admin/supplier";
	    }
	 @RequestMapping(value="admin/updateS",method=RequestMethod.GET)
	    public String updateCategory(@RequestParam("splrId") int splrId,Model m)
	    {
		 Supplier supplier=supplierDAO.getSupplier(splrId);
	        m.addAttribute("sup",supplier);
	         
	        List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
	        m.addAttribute("supplierList",listSupplier);
	        return "UpdateSupplier";
	    }
	   
	   @RequestMapping(value="/admin/updateSupplier",method=RequestMethod.POST)
	    public String updateNewSup(@RequestParam("splrId") int splrId,@RequestParam("splrName") String splrName,@RequestParam("splrAdd") String splrAddress,Model m)
	    {
		   Supplier supplier=supplierDAO.getSupplier(splrId);
		   supplier.setSplrName(splrName);
		   supplier.setSplrAddress(splrAddress);
	         
		   supplierDAO.updateSupplier(supplier);
	         
	        List<Supplier> supplierList=supplierDAO.retrieveSupplier();
	        m.addAttribute("supplierList",supplierList);
	         
	        return "redirect:/supplier";
	    }
	     
	
	

}
