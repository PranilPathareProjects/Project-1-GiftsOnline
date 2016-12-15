package com.niit.giftsonline.dao;

import com.niit.giftsonline.model.CartModel;
public interface CartDAO {
	void addCart(CartModel cm);
	String retrieveCarts(String username);
	void deleteCart(String id);
	void updateCart(String id, int quantity);
	String generateID();
	long getTotalPriceOfCart(String username);
	long getTotalQuantityOfCart(String username);
	void updateCartsWithOrderId(String id);
	String retriveCartsWithOrderId();
	void removeCartsWithOrderId();
}
