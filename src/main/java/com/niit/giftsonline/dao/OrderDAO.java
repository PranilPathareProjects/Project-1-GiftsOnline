package com.niit.giftsonline.dao;

import com.niit.giftsonline.model.OrderModel;

public interface OrderDAO {
	void addOrderInDB(OrderModel ordermodel);
	String generateID();
	long getTotalNumberOfOrders();
	String retriveAllOrders();
	String retriveAllOrdersByUsername(String username);
	void updateOrderDate(String id);
}
