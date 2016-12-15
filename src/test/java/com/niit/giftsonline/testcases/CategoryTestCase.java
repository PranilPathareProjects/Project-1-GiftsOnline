package com.niit.giftsonline.testcases;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.giftsonline.dao.CategoryDAO;
import com.niit.giftsonline.model.CategoryModel;

public class CategoryTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static CategoryModel categoryModel;
	
	@Autowired
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		categoryModel = (CategoryModel) context.getBean("categoryModel");
	}

	@Test
	public void getProductTestCase()
	{
		boolean status;
		String getproducts = categoryDAO.retrieveCategories();
		if(getproducts==null)
		{status = false;}
		else
		{status = true;}
		Assert.assertEquals(true, status);
	}
}
