package com.niit.giftsonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.giftsonline.dao.SupplierDAO;
import com.niit.giftsonline.model.SupplierModel;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierDAO sdao;
	
	@Autowired
	SupplierModel suppliermodel;
	
	@RequestMapping(value="/managesupplier", method=RequestMethod.GET)
	public ModelAndView addsupplier()
	{
		String newid = sdao.generateID();
		suppliermodel.setSupplier_id(newid);
		ModelAndView mav = new ModelAndView("adminManageSupplier", "supplier", suppliermodel);
		
		String supplierlist = sdao.retrieveSuppliers(); 
		mav.addObject("suplistkey", supplierlist);
		return mav;
	}
	
	@RequestMapping(value="/adminAddSupplier", method=RequestMethod.POST)
	public ModelAndView addsuppliertoDB(SupplierModel supmodel)
	{
		sdao.addSupplier(supmodel);
		
		String newid = sdao.generateID();
		suppliermodel.setSupplier_id(newid);
		ModelAndView mav = new ModelAndView("adminManageSupplier", "supplier", suppliermodel);
		
		String supplierlist = sdao.retrieveSuppliers(); 
		mav.addObject("suplistkey", supplierlist);
		return mav;
	}
	
	/*@RequestMapping(value="/showproducts", method=RequestMethod.GET)
	public ModelAndView showproducts() 
	{
		ModelAndView mav = new ModelAndView("adminManageSupplier", "command", new SupplierModel());
		String productlist = cdaoi.retrieveCategories(); 
		mav.addObject("prodlistkey", productlist);
		return mav;
	}*/
	
	@RequestMapping(value="/fetchsuppliertoupdate", method=RequestMethod.GET)
	public ModelAndView updatesupplier(@RequestParam("supplier_id") String id)
	{
		SupplierModel SupplierObj = sdao.fetchSupplierToUpdate(id);
		ModelAndView mav = new ModelAndView("adminManageSupplier", "supplier", SupplierObj); 
		String supplierlist = sdao.retrieveSuppliers(); 
		mav.addObject("suplistkey", supplierlist);
		mav.addObject("userClickedUpdateSupplier", "true");
		return mav;
	}	
	
	@RequestMapping(value="/adminUpdateSupplier", method=RequestMethod.POST)
	public ModelAndView updateproducttoDB(SupplierModel smod)
	{
		sdao.updateSupplier(smod);
		
		String newid = sdao.generateID();
		suppliermodel.setSupplier_id(newid);
		ModelAndView mav = new ModelAndView("adminManageSupplier", "supplier", suppliermodel);
		
		String supplierlist = sdao.retrieveSuppliers(); 
		mav.addObject("suplistkey", supplierlist);
		return mav;
	}
	
	@RequestMapping(value="/deletesupplier", method=RequestMethod.GET)
	public ModelAndView deleteSupplier(@RequestParam("supplier_id") String id)
	{
		sdao.deleteSupplier(id);
		
		String newid = sdao.generateID();
		suppliermodel.setSupplier_id(newid);
		ModelAndView mav = new ModelAndView("adminManageSupplier", "supplier", suppliermodel);
		
		String supplierlist = sdao.retrieveSuppliers(); 
		mav.addObject("suplistkey", supplierlist);
		return mav;
	}
}