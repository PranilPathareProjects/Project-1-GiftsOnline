package com.niit.giftsonline.dao;

import com.niit.giftsonline.model.OrderModel;

public interface OrderDAO {
	void addOrderInDB(OrderModel ordermodel);
	String generateID();
	long getTotalNumberOfOrders();
	String retriveAllOrders();
	String retriveAllOrdersByUsername(String username);
	void updateOrderDeliveredDate(String id);
	void updateOrderProcessedDate(String id);
	void resetProcessedDate(String id);
	void resetDeliveredDate(String id);
	
}
