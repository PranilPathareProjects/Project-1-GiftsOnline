package com.niit.giftsonline.dao;

import com.niit.giftsonline.model.SubcategoryModel;
public interface SubcategoryDAO {
	void addSubcategory(SubcategoryModel scm);
	String retrieveSubcategories();
	SubcategoryModel fetchSubcategoryToUpdate(String id);
	void deleteSubcategory(String id);
	void updateSubcategory(SubcategoryModel subcatmod);
	void setSubcategoryStatus(String id, String status);
	String generateID();
}
