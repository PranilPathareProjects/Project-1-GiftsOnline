package com.niit.giftsonline.model;

import java.sql.Date;

public class TempCartModel {

	private String cart_id;
	
	private String username;
	
	private String product_name;
	
	private int price;
	
	private int quantity;
	
	private Date date_of_addition;
	
	private int total_price;

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate_of_addition() {
		return date_of_addition;
	}

	public void setDate_of_addition(Date date_of_addition) {
		this.date_of_addition = date_of_addition;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
}
