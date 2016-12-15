package com.niit.giftsonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.giftsonline.dao.CategoryDAO;
import com.niit.giftsonline.model.CategoryModel;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO cdao;
	
	@Autowired
	CategoryModel categorymodel;
	
	/*For admin manage category first page*/
	@RequestMapping(value="/managecategory", method=RequestMethod.GET)
	public ModelAndView addcategory()
	{
		String newid = cdao.generateID();
		categorymodel.setCategory_id(newid);
		ModelAndView mav = new ModelAndView("adminManageCategory", "category", categorymodel);
		
		String categorylist = cdao.retrieveCategories(); 
		mav.addObject("catlistkey", categorylist);
		return mav;
	}
	
	/*For adding a category*/
	@RequestMapping(value="/adminAddCategory", method=RequestMethod.POST)
	public ModelAndView addcategorytoDB(CategoryModel catmodel)
	{
		catmodel.setCategory_status("Enabled");
		cdao.addCategory(catmodel);
		
		String newid = cdao.generateID();
		categorymodel.setCategory_id(newid);
		ModelAndView mav = new ModelAndView("adminManageCategory", "category", categorymodel);
		
		String categorylist = cdao.retrieveCategories(); 
		mav.addObject("catlistkey", categorylist);
		return mav;
	}
	
	/*@RequestMapping(value="/showproducts", method=RequestMethod.GET)
	public ModelAndView showproducts() 
	{
		ModelAndView mav = new ModelAndView("adminManageCategory", "command", new CategoryModel());
		String productlist = cdao.retrieveCategories(); 
		mav.addObject("prodlistkey", productlist);
		return mav;
	}*/
	
	/*For fecthing a category to update */
	@RequestMapping(value="/fetchcategorytoupdate", method=RequestMethod.GET)
	public ModelAndView updateproduct(@RequestParam("category_id") String id)
	{
		CategoryModel CategoryObj = cdao.fetchCategoryToUpdate(id);
		ModelAndView mav = new ModelAndView("adminManageCategory", "category", CategoryObj); 
		String categorylist = cdao.retrieveCategories(); 
		mav.addObject("catlistkey", categorylist);
		mav.addObject("userClickedUpdateCategory", "true");
		return mav;
	}	
	
	/*For updating a category */
	@RequestMapping(value="/adminUpdateCategory", method=RequestMethod.POST)
	public ModelAndView updateproducttoDB(CategoryModel catmod)
	{
		catmod.setCategory_status("Enabled");
		cdao.updateCategory(catmod);
		
		String newid = cdao.generateID();
		categorymodel.setCategory_id(newid);
		ModelAndView mav = new ModelAndView("adminManageCategory", "category", categorymodel);
		
		String categorylist = cdao.retrieveCategories(); 
		mav.addObject("catlistkey", categorylist);
		return mav;
	}
	
	/*For deleting a category */
	@RequestMapping(value="/deletecategory", method=RequestMethod.GET)
	public ModelAndView deleteCategory(@RequestParam("category_id") String id)
	{
		cdao.deleteCategory(id);
		
		String newid = cdao.generateID();
		categorymodel.setCategory_id(newid);
		ModelAndView mav = new ModelAndView("adminManageCategory", "category", categorymodel);
		
		String categorylist = cdao.retrieveCategories(); 
		mav.addObject("catlistkey", categorylist);
		return mav;
	}
	
	/*For enabling a category */
	@RequestMapping(value="/enablecategory", method=RequestMethod.GET)
	public ModelAndView enableCategory(@RequestParam("category_id") String id)
	{
		String status = "Enabled";
		cdao.setCategoryStatus(id, status);
		
		String newid = cdao.generateID();
		categorymodel.setCategory_id(newid);
		ModelAndView mav = new ModelAndView("adminManageCategory", "category", categorymodel);
		
		String categorylist = cdao.retrieveCategories(); 
		mav.addObject("catlistkey", categorylist);
		return mav;
	}
	
	/*For disabling a category */
	@RequestMapping(value="/disablecategory", method=RequestMethod.GET)
	public ModelAndView disableproduct(@RequestParam("category_id") String id)
	{
		String status = "Disabled";
		cdao.setCategoryStatus(id, status);
		
		String newid = cdao.generateID();
		categorymodel.setCategory_id(newid);
		ModelAndView mav = new ModelAndView("adminManageCategory", "category", categorymodel);
		
		String categorylist = cdao.retrieveCategories(); 
		mav.addObject("catlistkey", categorylist);
		return mav;
	}
}