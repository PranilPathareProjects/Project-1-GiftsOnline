package com.niit.giftsonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.giftsonline.dao.CategoryDAO;
import com.niit.giftsonline.dao.SubcategoryDAO;
import com.niit.giftsonline.daoimpl.SubcategoryDAOImpl;
import com.niit.giftsonline.model.CategoryModel;
import com.niit.giftsonline.model.SubcategoryModel;

@Controller
public class SubcategoryController {
	
	@Autowired
	SubcategoryDAO scdao;
	
	@Autowired
	CategoryDAO cdao;
	
	@Autowired
	SubcategoryModel subcategorymodel;
	
	@RequestMapping(value="/managesubcategory", method=RequestMethod.GET)
	public ModelAndView addsubcategory()
	{
		String newid = scdao.generateID();
		subcategorymodel.setSubcategory_id(newid);
		ModelAndView mav = new ModelAndView("adminManageSubcategory", "subcategory", subcategorymodel);
		
		String subcategorylist = scdao.retrieveSubcategories(); 
		mav.addObject("subcatlistkey", subcategorylist);
		
		String categorylist = cdao.retrieveCategories();
		mav.addObject("categorylistkey", categorylist);
		return mav;
	}
	
	@RequestMapping(value="/adminAddSubcategory", method=RequestMethod.POST)
	public ModelAndView addsubcategorytoDB(SubcategoryModel subcatmodel)
	{
		subcatmodel.setSubcategory_status("Enabled");
		scdao.addSubcategory(subcatmodel);
		
		String newid = scdao.generateID();
		subcategorymodel.setSubcategory_id(newid);
		ModelAndView mav = new ModelAndView("adminManageSubcategory", "subcategory", subcategorymodel);
		
		String subcategorylist = scdao.retrieveSubcategories(); 
		mav.addObject("subcatlistkey", subcategorylist);
		
		String categorylist = cdao.retrieveCategories();
		mav.addObject("categorylistkey", categorylist);
		return mav;
	}
	
	/*@RequestMapping(value="/showproducts", method=RequestMethod.GET)
	public ModelAndView showproducts() 
	{
		ModelAndView mav = new ModelAndView("adminManageSubcategory", "command", new SubcategoryModel());
		String productlist = cdaoi.retrieveCategories(); 
		mav.addObject("prodlistkey", productlist);
		return mav;
	}*/
	
	@RequestMapping(value="/fetchsubcategorytoupdate", method=RequestMethod.GET)
	public ModelAndView updatesubcategory(@RequestParam("subcategory_id") String id)
	{
		SubcategoryModel SubcategoryObj = scdao.fetchSubcategoryToUpdate(id);
		ModelAndView mav = new ModelAndView("adminManageSubcategory", "subcategory", SubcategoryObj); 
		String subcategorylist = scdao.retrieveSubcategories(); 
		mav.addObject("subcatlistkey", subcategorylist);
		
		String categorylist = cdao.retrieveCategories();
		mav.addObject("categorylistkey", categorylist);
		mav.addObject("userClickedUpdateSubcategory", "true");
		return mav;
	}	
	
	@RequestMapping(value="/adminUpdateSubcategory", method=RequestMethod.POST)
	public ModelAndView updateproducttoDB(SubcategoryModel subcatmod)
	{
		subcatmod.setSubcategory_status("Enabled");
		scdao.updateSubcategory(subcatmod);
		
		String newid = scdao.generateID();
		subcategorymodel.setSubcategory_id(newid);
		ModelAndView mav = new ModelAndView("adminManageSubcategory", "subcategory", subcategorymodel);
		
		String subcategorylist = scdao.retrieveSubcategories(); 
		mav.addObject("subcatlistkey", subcategorylist);
		
		String categorylist = cdao.retrieveCategories();
		mav.addObject("categorylistkey", categorylist);
		return mav;
	}
	
	@RequestMapping(value="/deletesubcategory", method=RequestMethod.GET)
	public ModelAndView deleteSubcategory(@RequestParam("subcategory_id") String id)
	{
		scdao.deleteSubcategory(id);
		
		String newid = scdao.generateID();
		subcategorymodel.setSubcategory_id(newid);
		ModelAndView mav = new ModelAndView("adminManageSubcategory", "subcategory", subcategorymodel);
		
		String subcategorylist = scdao.retrieveSubcategories(); 
		mav.addObject("subcatlistkey", subcategorylist);
		
		String categorylist = cdao.retrieveCategories();
		mav.addObject("categorylistkey", categorylist);
		return mav;
	}
	
	@RequestMapping(value="/enablesubcategory", method=RequestMethod.GET)
	public ModelAndView enableSubcategory(@RequestParam("subcategory_id") String id)
	{
		String status = "Enabled";
		scdao.setSubcategoryStatus(id, status);
		
		String newid = scdao.generateID();
		subcategorymodel.setSubcategory_id(newid);
		ModelAndView mav = new ModelAndView("adminManageSubcategory", "subcategory", subcategorymodel);
		
		String subcategorylist = scdao.retrieveSubcategories(); 
		mav.addObject("subcatlistkey", subcategorylist);
		
		String categorylist = cdao.retrieveCategories();
		mav.addObject("categorylistkey", categorylist);
		return mav;
	}
	
	@RequestMapping(value="/disablesubcategory", method=RequestMethod.GET)
	public ModelAndView disableproduct(@RequestParam("subcategory_id") String id)
	{
		String status = "Disabled";
		scdao.setSubcategoryStatus(id, status);
		
		String newid = scdao.generateID();
		subcategorymodel.setSubcategory_id(newid);
		ModelAndView mav = new ModelAndView("adminManageSubcategory", "subcategory", subcategorymodel);
		
		String subcategorylist = scdao.retrieveSubcategories(); 
		mav.addObject("subcatlistkey", subcategorylist);
		
		String categorylist = cdao.retrieveCategories();
		mav.addObject("categorylistkey", categorylist);
		return mav;
	}
}