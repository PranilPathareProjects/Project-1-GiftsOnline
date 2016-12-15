package com.niit.giftsonline.dao;

import com.niit.giftsonline.model.UserModel;
public interface UserDAO {
	void addUser(UserModel um);
	String retrieveUsers();
	UserModel fetchUserToUpdate(String id);
	void deleteUser(String id);
	void updateUser(UserModel usermod);
	void setUserStatus(String id, String status);
	long getTotalNumberOfUsers();
}