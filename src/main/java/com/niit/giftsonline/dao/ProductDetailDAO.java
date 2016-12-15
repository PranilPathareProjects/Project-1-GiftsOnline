package com.niit.giftsonline.dao;

import org.springframework.stereotype.Service;

import com.niit.giftsonline.model.ProductDetailModel;
import com.niit.giftsonline.model.ProductModel;
@Service
public interface ProductDetailDAO {
	void addProductDetail(ProductDetailModel pm);
	void deleteProductDetail(String id);
	String retrieveProductDetails();
	ProductDetailModel fetchProductDetailToUpdate(String id);
	void updateProductDetail(ProductDetailModel prodmod);
}
