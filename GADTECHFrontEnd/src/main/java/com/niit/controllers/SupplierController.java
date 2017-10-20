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
	
	
	 @RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
	   public String addSupplier(@RequestParam("splrId") int splrId,@RequestParam("splrName") String splrName,@RequestParam("splrAdd") String splrAddress,Model m)
	   {
		 Supplier supplier=new Supplier();
		 supplier.setSplrId(splrId);
		 supplier.setSplrName(splrName);
		 supplier.setSplrAddress(splrAddress);
	    
		 supplierDAO.addSupplier(supplier);
	         
	        List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
	        m.addAttribute("SupplierList",listSupplier);
	        return "redirect:/supplier";
	   }
	 @RequestMapping(value="/supplier",method=RequestMethod.GET)
     public String showSupplier(Model m)
     {
         Supplier supplier=new Supplier();
         m.addAttribute(supplier);
          
         List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
         m.addAttribute("supplierList",listSupplier);
         return "Supplier";
     }
	 
	 @RequestMapping(value="deleteSupplier/{splrId}",method=RequestMethod.GET)
	    public String deleteSupplier(@PathVariable("splrId")int splrId,Model m)
	    {
		 Supplier supplier=supplierDAO.getSupplier(splrId);
		 supplierDAO.deleteSupplier(supplier);
	        List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
	        m.addAttribute("supplierList",listSupplier);
	         
	        Supplier supplier1=new Supplier();
	        m.addAttribute(supplier1);
	         
	        return "redirect:/supplier";
	    }
	

}