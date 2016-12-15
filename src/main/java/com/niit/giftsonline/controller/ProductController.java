package com.niit.giftsonline.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.giftsonline.dao.CategoryDAO;
import com.niit.giftsonline.dao.ProductDAO;
import com.niit.giftsonline.dao.SupplierDAO;
import com.niit.giftsonline.model.ProductModel;
import com.niit.giftsonline.model.UserModel;

@Controller
public class ProductController {
	
	public static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductDAO pdao;
	
	@Autowired
	CategoryDAO cdao;
	
	@Autowired
	SupplierDAO sdao;
	
	@Autowired
	ProductModel productmodel;
	
	/* For add product form */
	@RequestMapping(value="/manageproduct", method=RequestMethod.GET)
	public ModelAndView addproduct()
	{
		String newid = pdao.generateID();
		productmodel.setProduct_id(newid);
		ModelAndView mav = new ModelAndView("adminManageProduct", "product", productmodel);
		
		String productlist = pdao.retrieveProducts();
		mav.addObject("prodlistkey", productlist);
		
		/*String productdetaillist = pddao.retrieveProductDetails();
		mav.addObject("productdetaillistkey", productdetaillist);*/
		
		String categorylist = cdao.retrieveCategoriesByStatus();
		mav.addObject("categorylistkey", categorylist);
		
		String supplierlist = sdao.retrieveSuppliers();
		mav.addObject("supplierlistkey", supplierlist);
		return mav;
	}
	
	/*For adding product */   
	@RequestMapping(value="/adminAddProduct", method=RequestMethod.POST)
	public ModelAndView addproducttoDB(ProductModel prodmodel)
	{
		prodmodel.setProduct_status("Enabled");
		pdao.addProduct(prodmodel);
		
		String path="E:\\Pranil Pathare\\Project_1_GiftsOnline\\GiftsOnline\\src\\main\\webapp\\resources\\product_images\\";
		path=path+String.valueOf(prodmodel.getProduct_id())+".jpg";
		File f=new File(path);
		MultipartFile multifile=prodmodel.getProduct_image();
		if(!multifile.isEmpty())
		{
		try
		{
		byte[] bytes=multifile.getBytes();
		FileOutputStream fos=new FileOutputStream(f);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		bos.write(bytes);
		bos.close();
		logger.debug("File Uploaded Successfully");
		}
		catch(Exception e)
		{
			logger.info("Exception Arised"+e);
		}
		}
		else
		{
			logger.debug("File is Empty not Uploaded");
		}
		
		String newid = pdao.generateID();
		productmodel.setProduct_id(newid);
		ModelAndView mav = new ModelAndView("adminManageProduct", "product", productmodel);
		
		String productlist = pdao.retrieveProducts(); 
		mav.addObject("prodlistkey", productlist);
		
		/*String productdetaillist = pddao.retrieveProductDetails();
		mav.addObject("productdetaillistkey", productdetaillist);*/
		
		String categorylist = cdao.retrieveCategoriesByStatus();
		mav.addObject("categorylistkey", categorylist);
		
		String supplierlist = sdao.retrieveSuppliers();
		mav.addObject("supplierlistkey", supplierlist);
		return mav;
	}
	
	/*@RequestMapping(value="/showproducts", method=RequestMethod.GET)
	public ModelAndView showproducts() 
	{
		ModelAndView mav = new ModelAndView("adminManageProduct", "command", new ProductModel());
		String productlist = pdao.retrieveProducts(); 
		mav.addObject("prodlistkey", productlist);
		return mav;
	}*/
	
	/* For fetching product to update */
	@RequestMapping(value="/fetchproducttoupdate", method=RequestMethod.GET)
	public ModelAndView updateproduct(@RequestParam("product_id") String id)
	{
		ProductModel ProductObj = pdao.fetchProductById(id);
		
		ModelAndView mav = new ModelAndView("adminManageProduct", "product", ProductObj); 
		String productlist = pdao.retrieveProducts(); 
		mav.addObject("prodlistkey", productlist);
		mav.addObject("userClickedUpdateProduct", "true");
		
		/*String productdetaillist = pddao.retrieveProductDetails();
		mav.addObject("productdetaillistkey", productdetaillist);*/
		
		String categorylist = cdao.retrieveCategoriesByStatus();
		mav.addObject("categorylistkey", categorylist);
		
		String supplierlist = sdao.retrieveSuppliers();
		mav.addObject("supplierlistkey", supplierlist);
		return mav;
	}	
	
	/* For updating product*/
	@RequestMapping(value="/adminUpdateProduct", method=RequestMethod.POST)
	public ModelAndView updateproducttoDB(ProductModel prodmod)
	{
		prodmod.setProduct_status("Enabled");
		pdao.updateProduct(prodmod);
		
		String path="E:\\Pranil Pathare\\Project_1_GiftsOnline\\GiftsOnline\\src\\main\\webapp\\resources\\product_images\\";
		path=path+String.valueOf(prodmod.getProduct_id())+".jpg";
		File f=new File(path);
		MultipartFile multifile=prodmod.getProduct_image();
		if(!multifile.isEmpty())
		{
		try
		{
		byte[] bytes=multifile.getBytes();
		FileOutputStream fos=new FileOutputStream(f);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		bos.write(bytes);
		bos.close();
		logger.debug("File Uploaded Successfully");
		}
		catch(Exception e)
		{
			logger.info("Exception Arised"+e);
		}
		}
		else
		{
			logger.debug("File is Empty not Uploaded");
		}
		
		String newid = pdao.generateID();
		productmodel.setProduct_id(newid);
		ModelAndView mav = new ModelAndView("adminManageProduct", "product", productmodel);
		
		String productlist = pdao.retrieveProducts(); 
		mav.addObject("prodlistkey", productlist);
		
		/*String productdetaillist = pddao.retrieveProductDetails();
		mav.addObject("productdetaillistkey", productdetaillist);*/
		
		String categorylist = cdao.retrieveCategoriesByStatus();
		mav.addObject("categorylistkey", categorylist);
		
		String supplierlist = sdao.retrieveSuppliers();
		mav.addObject("supplierlistkey", supplierlist);
		return mav;
	}
	
	/* For deleting product */
	@RequestMapping(value="/deleteproduct", method=RequestMethod.GET)
	public ModelAndView deleteProduct(@RequestParam("product_id") String id)
	{
		pdao.deleteProduct(id);
		
		ProductModel productmodel = new ProductModel();
		String newid = pdao.generateID();
		productmodel.setProduct_id(newid);
		ModelAndView mav = new ModelAndView("adminManageProduct", "product", productmodel);
		
		String productlist = pdao.retrieveProducts();
		mav.addObject("prodlistkey", productlist);
		
		/*String productdetaillist = pddao.retrieveProductDetails();
		mav.addObject("productdetaillistkey", productdetaillist);*/
		
		String categorylist = cdao.retrieveCategoriesByStatus();
		mav.addObject("categorylistkey", categorylist);
		
		String supplierlist = sdao.retrieveSuppliers();
		mav.addObject("supplierlistkey", supplierlist);
		return mav;
	}
	
	/*For enabling product*/
	@RequestMapping(value="/enableproduct", method=RequestMethod.GET)
	public ModelAndView enableProduct(@RequestParam("product_id") String id)
	{
		String status = "Enabled";
		pdao.setProductStatus(id, status);
		
		String newid = pdao.generateID();
		productmodel.setProduct_id(newid);
		ModelAndView mav = new ModelAndView("adminManageProduct", "product", productmodel);
		
		String jsonstring = pdao.retrieveProducts();
		mav.addObject("prodlistkey", jsonstring);
		
		/*String productdetaillist = pddao.retrieveProductDetails();
		mav.addObject("productdetaillistkey", productdetaillist);*/
		
		String categorylist = cdao.retrieveCategoriesByStatus();
		mav.addObject("categorylistkey", categorylist);
		
		String supplierlist = sdao.retrieveSuppliers();
		mav.addObject("supplierlistkey", supplierlist);
		return mav;
	}
	
	/*For disabling product*/
	@RequestMapping(value="/disableproduct", method=RequestMethod.GET)
	public ModelAndView disableproduct(@RequestParam("product_id") String id)
	{
		String status = "Disabled";
		pdao.setProductStatus(id, status);
		
		String newid = pdao.generateID();
		productmodel.setProduct_id(newid);
		ModelAndView mav = new ModelAndView("adminManageProduct", "product", productmodel);
		
		String jsonstring = pdao.retrieveProducts();
		mav.addObject("prodlistkey", jsonstring);
		
		/*String productdetaillist = pddao.retrieveProductDetails();
		mav.addObject("productdetaillistkey", productdetaillist);*/
		
		String categorylist = cdao.retrieveCategoriesByStatus();
		mav.addObject("categorylistkey", categorylist);
		
		String supplierlist = sdao.retrieveSuppliers();
		mav.addObject("supplierlistkey", supplierlist);
		return mav;
	}
	
	/* To fetch products when we click on a category on navbar */
	@RequestMapping(value="/fetchproductsbycategory", method=RequestMethod.GET)
	public ModelAndView fetchProductsByCategory(@RequestParam("category_id") String id)
	{
		String productslist = pdao.fetchProductsByCategory(id);
		ModelAndView mav = new ModelAndView("displayProducts", "user", new UserModel());
		mav.addObject("displayprodlist", productslist);
		return mav;
	}
	
	@RequestMapping(value="/selectedproduct", method=RequestMethod.GET)
	public ModelAndView selectedproduct(@RequestParam("id") String id)
	{
		ModelAndView mav = new ModelAndView("selectedProduct", "user", new UserModel());
		String selectedproduct = pdao.fetchSelectedProductById(id);
		mav.addObject("selectedproduct", selectedproduct);
		return mav;
	}
}