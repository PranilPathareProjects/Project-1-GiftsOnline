package com.niit.giftsonline.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.giftsonline.dao.ProductDAO;
import com.niit.giftsonline.model.ProductModel;

public class ProductTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static ProductModel productModel;
	
	@Autowired
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.giftsonline.*");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		productModel = (ProductModel) context.getBean("productModel");
	}

	@Test
	public void getProductTestCase()
	{
		boolean status;
		String getproducts = productDAO.retrieveProducts();
		if(getproducts==null)
		{status = false;}
		else
		{status = true;}
		assertEquals(true, status);
	}
}
