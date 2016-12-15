package com.niit.giftsonline.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.niit.giftsonline.dao.ProductDetailDAO;
import com.niit.giftsonline.model.ProductDetailModel;

@Repository("productDetailDAO")
public class ProductDetailDAOImpl implements ProductDetailDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDetailDAOImpl()
	{	
	}
	
	@Override
	public void addProductDetail(ProductDetailModel pm) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(pm);
		tran.commit();
		session.close();
	}
	
	@Override
	public String retrieveProductDetails() 
	{	
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List lipm = session.createQuery("from ProductDetailModel").list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(lipm);
		tran.commit();
		session.close();
		return jsonlist;
	}

	@Override
	public void deleteProductDetail(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		ProductDetailModel productobj = (ProductDetailModel)session.get(ProductDetailModel.class, id);
		session.delete(productobj);
		tran.commit();
		session.close();
	}
	
	@Override
	public ProductDetailModel fetchProductDetailToUpdate(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		ProductDetailModel ProductObject = (ProductDetailModel)session.get(ProductDetailModel.class, id);
		tran.commit();
		session.close();
		return ProductObject;
	}
	
	@Override
	public void updateProductDetail(ProductDetailModel prodmod) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(prodmod);
		tran.commit();
		session.close();		
	}
}
