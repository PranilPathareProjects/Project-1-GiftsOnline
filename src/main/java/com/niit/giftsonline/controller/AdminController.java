package com.niit.giftsonline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.giftsonline.dao.OrderDAO;
import com.niit.giftsonline.dao.UserCredentialDAO;
import com.niit.giftsonline.dao.UserDAO;

@Controller
public class AdminController {
	
	public static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	UserDAO userdao;
	
	@Autowired
	UserCredentialDAO usercreddao;
	
	@Autowired
	OrderDAO orderdao;
	
	/* For admin panel demo */
	@RequestMapping("/admin")
	public String admin(Model model)
	{
		logger.debug("Start of admin method");
		long total_users = userdao.getTotalNumberOfUsers();
		model.addAttribute("totalusers", total_users);
		logger.info("total_users"+total_users);
		long total_orders = orderdao.getTotalNumberOfOrders();
		model.addAttribute("totalorders", total_orders);
		long total_activeusers = usercreddao.getTotalNumberOfActiveUsers();
		logger.info("total_activeusers = "+total_activeusers);
		double percent = (long)(((float)total_activeusers/total_users) * 100);
		logger.info("percent = "+percent);
		model.addAttribute("percent", percent);
		logger.debug("End of admin method");
		return "adminPage";
	}
	
	@RequestMapping("/outofstock")
	public String outOfStock()
	{
		logger.debug("Start of out of stock method");
		logger.debug("End of out of stock method");
		return "adminOutOfStockProducts";
	}
	
	@RequestMapping("/salesreport")
	public String salesReport()
	{
		logger.debug("Start of sales report method");
		logger.debug("End of sales report method");
		return "adminSalesReport";
	}
}
