package com.niit.giftsonline.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.giftsonline.dao.CartDAO;
import com.niit.giftsonline.dao.CategoryDAO;
import com.niit.giftsonline.dao.OrderDAO;
import com.niit.giftsonline.dao.UserCredentialDAO;
import com.niit.giftsonline.dao.UserDAO;
import com.niit.giftsonline.model.UserCredentialModel;
import com.niit.giftsonline.model.UserModel;

@Controller
public class UserController {
	
	public static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	CategoryDAO cdao;
	
	@Autowired
	UserDAO udao;
	
	@Autowired
	CartDAO cartdao;
	
	@Autowired
	OrderDAO orderdao;
	
	@Autowired
	UserCredentialDAO ucdao;
	
	@Autowired
	UserCredentialModel ucm;
	
	@RequestMapping(value="/registeruser", method=RequestMethod.POST)
	public ModelAndView addusertoDB(UserModel usmodel)
	{
		boolean registrationstatus;
		ModelAndView mav = new ModelAndView("index", "user", new UserModel());
		try {
			udao.addUser(usmodel);
			/*System.out.println("*****************");
			System.out.println("User saved");
			System.out.println("*****************");*/
			//UserCredentialModel ucm = new UserCredentialModel();
			ucm.setUserName(usmodel.getUserName());
			ucm.setPassword(usmodel.getUser_password());
			ucm.setEnabled(true);
			ucm.setRole("ROLE_USER");
			ucdao.addUserCredential(ucm);
			System.out.println("*****************");
			System.out.println("Cred saved");
			System.out.println("*****************");
			registrationstatus = true;
		} catch (Exception e) {
			e.printStackTrace();
			registrationstatus = false;
		}
		mav.addObject("successMessage", registrationstatus);
		return mav;
	}
	
	@RequestMapping(value="/validatelogin", method=RequestMethod.POST)
	public ModelAndView loginChecker(ModelAndView mav, HttpSession session)
	{
		logger.debug("Start of loginChecker method");
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String role = "ROLE_USER";
		logger.info("Username is"+ username);
		for(GrantedAuthority authority : authorities)
		{	
			if(authority.getAuthority().equals(role))
			{
				mav = new ModelAndView("index", "user", new UserModel());
				session.setAttribute("loggedinuser", username);
				session.setAttribute("userloggedin", true);
				long total_quantity = cartdao.getTotalQuantityOfCart(username);
				session.setAttribute("total_quantity", total_quantity);
				/*String cartlist = cartdao.retrieveCarts(username);
				
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
				}*/
				logger.debug("End of loginChecker method");
			}
			else
			{
				long total_users = udao.getTotalNumberOfUsers();
				long total_orders = orderdao.getTotalNumberOfOrders();
				long total_activeusers = ucdao.getTotalNumberOfActiveUsers();
				mav = new ModelAndView("adminPage");
				mav.addObject("totalusers", total_users);
				mav.addObject("totalorders", total_orders);
				long percent = (long)(((float)total_activeusers/total_users) * 100);
				mav.addObject("percent", percent);
				session.setAttribute("loggedinuser", username);
				logger.debug("End of loginChecker method");
			}
		}
		return mav;
	}
	
	@RequestMapping(value="/perform_logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session, HttpServletRequest request, HttpServletResponse response)
	{
		logger.debug("Start of logout method");
		session=request.getSession();
		session.invalidate();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    
		ModelAndView mav = new ModelAndView("index", "user", new UserModel());
		session=request.getSession();
		String categorylist = cdao.retrieveCategoriesByStatus();
		session.setAttribute("catlistkey", categorylist);
		session.setAttribute("total_quantity", 0);
		session.setAttribute("userloggedin", false);
		logger.debug("End of logout method");
		return mav;
	}
	
	@RequestMapping("/loginerror")
	public ModelAndView loginError()
	{
		logger.debug("Start of loginerror method");
		ModelAndView mav = new ModelAndView("login", "user", new UserModel());
		mav.addObject("error", "Invalid Credentials! Please try again");
		logger.debug("End of loginerror method");
		return mav;
	}
	
	@RequestMapping("/accessdenied")
	public ModelAndView accessDenied(HttpSession session)
	{
		logger.debug("Start of accessdenied method");
		ModelAndView mav = new ModelAndView("index", "user", new UserModel());
		mav.addObject("error", "You are not authorized to access this page");
		logger.debug("End of accessdenied method");
		return mav;
	}
}