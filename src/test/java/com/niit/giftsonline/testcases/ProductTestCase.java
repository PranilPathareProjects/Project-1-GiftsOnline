package com.niit.giftsonline.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.giftsonline.dao.ProductDAO;
import com.niit.giftsonline.model.ProductModel;

public class ProductTestCase {

	/*@Autowired
	AnnotationConfigApplicationContext context;*/
	
	@Autowired
	ProductModel productModel;
	
	@Autowired
	ProductDAO productDAO;
	
	/*@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.giftsonline.*");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		productModel = (ProductModel) context.getBean("productModel");
	}*/

	@Test
	public void getProductTestCase()
	{
		boolean status;
		String productid = productDAO.generateID();
		if(productid=="P007")
		{status = false;}
		else
		{status = true;}
		assertEquals(true, status);
	}
}
