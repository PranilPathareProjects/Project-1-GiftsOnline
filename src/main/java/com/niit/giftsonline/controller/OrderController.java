package com.niit.giftsonline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.giftsonline.dao.OrderDAO;

@Controller
public class OrderController {
	
	public static Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderDAO orderdao;
	
	@RequestMapping("/manageorders")
	public String manageOrders(Model model)
	{
		String orderslist = orderdao.retriveAllOrders(); 
		model.addAttribute("orders", orderslist);
		return "adminManageOrder";
	}
	
	@RequestMapping("/setdate")
	public String setdate(@RequestParam("id") String id, Model model)
	{
		orderdao.updateOrderDate(id);
		
		String orderslist = orderdao.retriveAllOrders(); 
		model.addAttribute("orders", orderslist);
		return "adminManageOrder";
	}
}
