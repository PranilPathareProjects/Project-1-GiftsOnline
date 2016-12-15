package com.niit.giftsonline.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Orders")
@Component
public class OrderModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String order_id;
	
	private String username;
	
	@Embedded
	private ShippingAddressModel shippingaddressmodel;
	
	@Embedded
	private BillingAddressModel billingaddressmodel;
	
	@Embedded
	private PaymentMethodModel paymentmethodmodel;
	
	@Column(name = "status", columnDefinition = "varchar(20) default 'Pending'", insertable = false)
	private String order_status;
	
	//@Generated(GenerationTime.INSERT)
	@Column(name = "date_added", columnDefinition = "date default sysdate", insertable = false)
	private Date date_of_addition;
	
	private Date date_processed;
	
	private Date date_delivered;
	
	private int total_price;
	
	/*@OneToMany(mappedBy="ordermodel")
	private List<CartModel> cart;*/
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public ShippingAddressModel getShippingaddressmodel() {
		return shippingaddressmodel;
	}
	public void setShippingaddressmodel(ShippingAddressModel shippingaddressmodel) {
		this.shippingaddressmodel = shippingaddressmodel;
	}
	public BillingAddressModel getBillingaddressmodel() {
		return billingaddressmodel;
	}
	public void setBillingaddressmodel(BillingAddressModel billingaddressmodel) {
		this.billingaddressmodel = billingaddressmodel;
	}
	public PaymentMethodModel getPaymentmethodmodel() {
		return paymentmethodmodel;
	}
	public void setPaymentmethodmodel(PaymentMethodModel paymentmethodmodel) {
		this.paymentmethodmodel = paymentmethodmodel;
	}

	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
	public Date getDate_of_addition() {
		return date_of_addition;
	}

	public void setDate_of_addition(Date date_of_addition) {
		this.date_of_addition = date_of_addition;
	}
	public Date getDate_processed() {
		return date_processed;
	}
	public void setDate_processed(Date date_processed) {
		this.date_processed = date_processed;
	}
	public Date getDate_delivered() {
		return date_delivered;
	}
	public void setDate_delivered(Date date_delivered) {
		this.date_delivered = date_delivered;
	}
	/*public List<CartModel> getCart() {
		return cart;
	}
	public void setCart(List<CartModel> cart) {
		this.cart = cart;
	}*/
}
