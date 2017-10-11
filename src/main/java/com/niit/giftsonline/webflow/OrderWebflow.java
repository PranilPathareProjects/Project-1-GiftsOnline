package com.niit.giftsonline.webflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.giftsonline.dao.OrderDAO;
import com.niit.giftsonline.model.BillingAddressModel;
import com.niit.giftsonline.model.OrderModel;
import com.niit.giftsonline.model.PaymentMethodModel;
import com.niit.giftsonline.model.ShippingAddressModel;

@Component
public class OrderWebflow {

	public static Logger logger = LoggerFactory.getLogger(OrderWebflow.class);
	
	@Autowired
	OrderModel ordermodel;
	
	@Autowired
	OrderDAO orderdao;
	
	public OrderModel initFlow() {
		logger.debug("Start of initFlow method");
		ordermodel = new OrderModel();
		logger.debug("End of initFlow method");
		return ordermodel; 
	}
	
	public String addShippingAddress(OrderModel ordermod, ShippingAddressModel shippaddmod){
		logger.debug("Start of addShippingAddress method");
		ordermod.setShippingaddressmodel(shippaddmod);
		logger.debug("End of addShippingAddress method");
		return "success";
	}
	
	public String addBillingAddress(OrderModel ordermod, BillingAddressModel billaddmod){
		logger.debug("Start of addBillingAddress method");
		ordermod.setBillingaddressmodel(billaddmod);
		logger.debug("End of addBillingAddress method");
		return "success";
	}
	
	public String addPaymentMethod(OrderModel ordermod, PaymentMethodModel paymentmethodmodel){
		logger.debug("Start of addPaymentMethod method");
		ordermod.setPaymentmethodmodel(paymentmethodmodel);
		this.orderAdded(ordermod);
		logger.debug("End of addPaymentMethod method");
		return "success";
	}
	
	public void orderAdded(OrderModel ordermod)
	{
		logger.debug("Start of orderAdded method");
		orderdao.addOrderInDB(ordermod);
		logger.debug("Start of orderAdded method");
	}
	
	/*for (Map.Entry<String, CartModel> entry : productincart.entrySet()) {
	     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().getProduct_name());
	}*/
}