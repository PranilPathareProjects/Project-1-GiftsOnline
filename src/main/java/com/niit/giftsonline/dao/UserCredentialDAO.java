package com.niit.giftsonline.dao;

import com.niit.giftsonline.model.UserCredentialModel;
import com.niit.giftsonline.model.UserModel;
public interface UserCredentialDAO {
	void addUserCredential(UserCredentialModel ucm);
	String retrieveUserCredentials();
	UserCredentialModel fetchUserCredToUpdate(String username);
	void updateUserCredentials(UserCredentialModel usercredmod);
	void setUserCredStatus(String id, boolean status);
	/*void deleteUser(String id);
	String generateID();*/
	long getTotalNumberOfActiveUsers();
}