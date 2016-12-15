package com.niit.giftsonline.dao;

import com.niit.giftsonline.model.SupplierModel;
public interface SupplierDAO {
	void addSupplier(SupplierModel sm);
	String retrieveSuppliers();
	SupplierModel fetchSupplierToUpdate(String id);
	void deleteSupplier(String id);
	void updateSupplier(SupplierModel prodmod);
	String generateID();
}
