package com.niit.giftsonline.dao;

import org.springframework.stereotype.Service;

import com.niit.giftsonline.model.ProductModel;
@Service
public interface ProductDAO {
	void addProduct(ProductModel pm);
	String retrieveProducts();
	ProductModel fetchProductById(String id);
	void deleteProduct(String id);
	void updateProduct(ProductModel prodmod);
	void setProductStatus(String id, String status);
	String generateID();
	String fetchProductsByCategory(String id);
	String fetchSelectedProductById(String id);
}
