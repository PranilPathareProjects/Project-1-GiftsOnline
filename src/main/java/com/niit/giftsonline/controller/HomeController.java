package com.niit.giftsonline.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.giftsonline.dao.CartDAO;
import com.niit.giftsonline.dao.CategoryDAO;
import com.niit.giftsonline.dao.OrderDAO;
import com.niit.giftsonline.dao.ProductDAO;
import com.niit.giftsonline.model.UserModel;


@Controller
public class HomeController {
	
	public static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ProductDAO pdao;
	
	@Autowired
	CategoryDAO cdao;
	
	@Autowired
	CartDAO cartdao;

	@Autowired
	OrderDAO orderdao;
	
	@RequestMapping("/")
	public ModelAndView index(HttpSession session) /**/
	{
		logger.debug("Start of index method");
		ModelAndView mav = new ModelAndView("index", "user", new UserModel());
		String categorylist = cdao.retrieveCategoriesByStatus();
		session.setAttribute("catlistkey", categorylist);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		long total_quantity = cartdao.getTotalQuantityOfCart(username);
		session.setAttribute("total_quantity", total_quantity);
		session.setAttribute("userloggedin", false);
		//mav.addObject("catlistkey", categorylist);
		logger.debug("End of index method");
		return mav;
	}
	
	@RequestMapping("/home")
	public ModelAndView home(HttpSession session)
	{
		logger.debug("Start of home method");
		ModelAndView mav = new ModelAndView("index", "user", new UserModel());
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		long total_quantity = cartdao.getTotalQuantityOfCart(username);
		session.setAttribute("total_quantity", total_quantity);
		logger.debug("End of home method");
		return mav;
	}
	
	@RequestMapping("/backtohome")
	public ModelAndView backtohome(HttpSession session)
	{
		logger.debug("Start of back to home method");
		cartdao.removeCartsWithOrderId();
		ModelAndView mav = new ModelAndView("index", "user", new UserModel());
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		long total_quantity = cartdao.getTotalQuantityOfCart(username);
		session.setAttribute("total_quantity", total_quantity);
		logger.debug("End of back to home method");
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView login()
	{
		logger.debug("Start of login method");
		ModelAndView mav = new ModelAndView("login", "user", new UserModel());
		logger.debug("End of login method");
		return mav;
	}
	/*@RequestMapping("/flowers")
	public ModelAndView flowers(Model model)
	{
		ModelAndView mav = new ModelAndView("flowers", "user", new UserModel());
		return mav;
	}
	
	@RequestMapping("/cakes")
	public ModelAndView cakes()
	{
		ModelAndView mav = new ModelAndView("cakes", "user", new UserModel());
		return mav;
	}
	
	@RequestMapping("/giftsformen")
	public ModelAndView giftsformen()
	{
		ModelAndView mav = new ModelAndView("cakes", "user", new UserModel());
		return mav;
	}
	
	@RequestMapping("/giftsforwomen")
	public ModelAndView giftsforwomen()
	{
		ModelAndView mav = new ModelAndView("giftsForWomen", "user", new UserModel());
		return mav;
	}*/
	
	@RequestMapping("/aboutus")
	public ModelAndView about()
	{
		logger.debug("Start of about method");
		ModelAndView mav = new ModelAndView("about", "user", new UserModel());
		logger.debug("End of about method");
		return mav;	
	}
	
	@RequestMapping("/contactus")
	public ModelAndView contact()
	{
		logger.debug("Start of contact method");
		ModelAndView mav = new ModelAndView("contact", "user", new UserModel());
		logger.debug("End of contact method");
		return mav;	
	}
	
	/*@RequestMapping("/validate")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model)
	{
		if(username.equals("niit") && password.equals("niit"))
		{
			model.addAttribute("message", "Login successful");
			return "index";
		}
		else
		{
			model.addAttribute("message", "Invalid username/password, Please try again");
			return "index";
		}
	}*/
	
	@RequestMapping("/trackorder")
	public ModelAndView trackOrder()
	{
		logger.debug("Start of trackOrder method");
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		ModelAndView mav = new ModelAndView("trackOrder", "user", new UserModel());
		String orderlist = orderdao.retriveAllOrdersByUsername(username);
		
		if(orderlist==null)
		{
			mav.addObject("OrderNotPlaced", true);
		}
		else
		{
			mav.addObject("OrderNotPlaced", false);
			mav.addObject("orderlistbyuser", orderlist);
		}
		logger.debug("End of trackOrder method");
		return mav;	
	}
	
	@RequestMapping("/cart")
	public ModelAndView cart(HttpSession session)
	{
		logger.debug("Start of cart method");
		ModelAndView mav = new ModelAndView("cart", "user", new UserModel());
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
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
			logger.info("In cart method price = "+total_price);
			
			long total_quantity = cartdao.getTotalQuantityOfCart(username);
			session.setAttribute("total_quantity", total_quantity);
			logger.info("In cart method quantity = "+total_quantity);
		}	
		logger.debug("End of cart method");
		return mav;
	}
}