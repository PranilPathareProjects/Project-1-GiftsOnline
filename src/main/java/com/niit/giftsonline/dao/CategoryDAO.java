package com.niit.giftsonline.dao;

import com.niit.giftsonline.model.CategoryModel;

public interface CategoryDAO {
	void addCategory(CategoryModel cm);
	String retrieveCategories();
	CategoryModel fetchCategoryToUpdate(String id);
	void deleteCategory(String id);
	void updateCategory(CategoryModel catmod);
	void setCategoryStatus(String id, String status);
	String generateID();
	String retrieveCategoriesByStatus();
}
