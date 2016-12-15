package com.niit.giftsonline.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.giftsonline.dao.CartDAO;
import com.niit.giftsonline.dao.ProductDAO;
import com.niit.giftsonline.model.CartModel;
import com.niit.giftsonline.model.ProductModel;
import com.niit.giftsonline.model.UserModel;

@Controller
public class CartController {
	
	@Autowired
	CartDAO cartdao;
	
	@Autowired
	CartModel cartmodel;
	
	@Autowired
	ProductModel productmodel;
	
	@Autowired
	ProductDAO productdao;
	
	/*for adding to cart*/ 
	@RequestMapping(value="/addtocart", method=RequestMethod.GET)
	public ModelAndView addcarttoDB(@RequestParam("id") String id, HttpSession session)
	{
		productmodel = productdao.fetchProductById(id);
		cartmodel.setProduct_name(productmodel.getProduct_name());
		cartmodel.setPrice(productmodel.getProduct_price());
		System.out.println(cartmodel.getProduct_name());
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		cartmodel.setUsername(username);
		cartdao.addCart(cartmodel);
		
		ModelAndView mav = new ModelAndView("cart", "user", new UserModel());
		String cartlist = cartdao.retrieveCarts(username);
		mav.addObject("cartlist", cartlist);
		
		long total_price = cartdao.getTotalPriceOfCart(username);
		mav.addObject("total_price", total_price);
		
		long total_quantity = cartdao.getTotalQuantityOfCart(username);
		session.setAttribute("total_quantity", total_quantity);
			
		return mav;
	}
	
	/*for removing a product from cart*/
	@RequestMapping(value="/removeproduct", method=RequestMethod.GET)
	public ModelAndView deleteCart(@RequestParam("id") String id, HttpSession session)
	{
		cartdao.deleteCart(id);

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		ModelAndView mav = new ModelAndView("cart", "user", new UserModel());
		String cartlist = cartdao.retrieveCarts(username);
		
		if(cartlist==null)
		{	
			mav.addObject("UserCartEmpty", true);
			long total_quantity = cartdao.getTotalQuantityOfCart(username);
			session.setAttribute("total_quantity", total_quantity);
		}
		else
		{
			mav.addObject("cartlist", cartlist);
			
			long total_price = cartdao.getTotalPriceOfCart(username);
			mav.addObject("total_price", total_price);
			
			long total_quantity = cartdao.getTotalQuantityOfCart(username);
			session.setAttribute("total_quantity", total_quantity);
		}
		return mav;
	}
	
	/*For updating the quantity of product in cart*/
	@RequestMapping(value="/updatequantity", method=RequestMethod.GET)
	public ModelAndView updateproducttoDB(@RequestParam("id") String id, @RequestParam("quantity") int quantity, HttpSession session)
	{
		cartdao.updateCart(id, quantity);
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		ModelAndView mav = new ModelAndView("cart", "user", new UserModel());
		String cartlist = cartdao.retrieveCarts(username);
		mav.addObject("cartlist", cartlist);
		
		long total_price = cartdao.getTotalPriceOfCart(username);
		mav.addObject("total_price", total_price);
		
		long total_quantity = cartdao.getTotalQuantityOfCart(username);
		session.setAttribute("total_quantity", total_quantity);
			
		return mav;
	}
	
	@RequestMapping(value="/generatereceipt", method=RequestMethod.GET)
	public ModelAndView removeProductsFromCartAfterOrder()
	{
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		ModelAndView mav = new ModelAndView("receipt");
		String cartsforreceipt = cartdao.retriveCartsWithOrderId();
		mav.addObject("cartsreceipt", cartsforreceipt);
		long total_price = cartdao.getTotalPriceOfCart(username);
		mav.addObject("totalprice", total_price);
		return mav;
	}
}