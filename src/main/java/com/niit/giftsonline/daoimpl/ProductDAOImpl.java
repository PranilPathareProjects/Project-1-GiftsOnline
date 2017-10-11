package com.niit.giftsonline.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.niit.giftsonline.dao.ProductDAO;
import com.niit.giftsonline.model.ProductModel;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	public static Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDAOImpl()
	{	
	}
	
	@Override
	public void addProduct(ProductModel pm) {
		logger.debug("Start of addProduct method");
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(pm);
		tran.commit();
		session.close();
		logger.debug("End of addProduct method");
	}

	@Override
	public String retrieveProducts() 
	{	
		logger.debug("Start of retrieveProducts method");
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List lipm = session.createQuery("from ProductModel").list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(lipm);
		tran.commit();
		session.close();
		logger.debug("End of retrieveProducts method");
		return jsonlist;
	}

	@Override
	public ProductModel fetchProductById(String id) {
		logger.debug("Start of fetchProductToUpdate method");
		logger.info("The ID = "+id);
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		ProductModel ProductObject = (ProductModel)session.get(ProductModel.class, id);
		tran.commit();
		session.close();
		logger.debug("End of fetchProductToUpdate method");
		return ProductObject;
	}

	@Override
	public void deleteProduct(String id) {
		logger.debug("Start of deleteProduct method");
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		ProductModel productobj = (ProductModel)session.get(ProductModel.class, id);
		session.delete(productobj);
		tran.commit();
		session.close();
		logger.debug("End of deleteProduct method");
	}

	@Override
	public void updateProduct(ProductModel prodmod) {
		logger.debug("Start of updateProduct method");
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(prodmod);
		tran.commit();
		session.close();
		logger.debug("End of updateProduct method");
	}
	
	@Override
	public void setProductStatus(String id, String status) {
		logger.debug("Start of setProductStatus method");
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		ProductModel prodmod = (ProductModel) session.get(ProductModel.class,id);
		prodmod.setProduct_status(status);
		session.update(prodmod);
		tran.commit();
		session.close();		
		logger.debug("End of setProductStatus method");
	}
	
	@Override
	public String generateID() {
		logger.debug("Start of generateID method");
		String newID;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List templist = session.createQuery("from ProductModel order by product_id desc").list();
		if(templist.size()==0)
		{
			newID="P001";	
		}
		else
		{
		ProductModel Obj = (ProductModel) templist.get(0);
		String id = Obj.getProduct_id();
		String temp = id.substring(0, 1);
		int tempID = Integer.parseInt(id.substring(1, 4));
		tempID++;
		newID = temp + String.format("%03d", tempID);
		}
		tran.commit();
		session.close();
		logger.debug("End of generateID method");
		return newID;
	}

	@Override
	public String fetchProductsByCategory(String id) {
		logger.debug("Start of fetchProductsByCategory method");
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Criteria criteria = session.createCriteria(ProductModel.class);
		criteria.add(Restrictions.eq("category_id", id))
				.add(Restrictions.eq("product_status", "Enabled"));
		List lipm = criteria.list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(lipm);
		tran.commit();
		session.close();
		logger.debug("End of fetchProductsByCategory method");
		return jsonlist;
	}
	
	@Override
	public String fetchSelectedProductById(String id) {
		logger.debug("Start of fetchProductToUpdate method");
		logger.info("The ID = "+id);
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		ProductModel ProductObject = (ProductModel)session.get(ProductModel.class, id);
		Gson gs = new Gson();
		String jsonlist = gs.toJson(ProductObject);
		tran.commit();
		session.close();
		logger.debug("End of fetchProductToUpdate method");
		return jsonlist;
	}
}
