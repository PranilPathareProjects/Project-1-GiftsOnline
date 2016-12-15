package com.niit.giftsonline.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.niit.giftsonline.dao.CategoryDAO;
import com.niit.giftsonline.model.CategoryModel;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDAOImpl()
	{	
	}
	
	@Override
	public void addCategory(CategoryModel cm) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(cm);
		tran.commit();
		session.close();
	}

	@Override
	public String retrieveCategories() 
	{	
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List licm = session.createQuery("from CategoryModel").list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(licm);
		tran.commit();
		session.close();
		return jsonlist;
	}

	@Override
	public CategoryModel fetchCategoryToUpdate(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		CategoryModel CategoryObject = (CategoryModel)session.get(CategoryModel.class, id);
		tran.commit();
		session.close();
		return CategoryObject;
	}

	@Override
	public void deleteCategory(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		CategoryModel categoryobj = (CategoryModel)session.get(CategoryModel.class, id);
		session.delete(categoryobj);
		tran.commit();
		session.close();
	}

	@Override
	public void updateCategory(CategoryModel catmod) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(catmod);
		tran.commit();
		session.close();		
	}
	
	@Override
	public void setCategoryStatus(String id, String status) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		CategoryModel catmod = (CategoryModel) session.get(CategoryModel.class,id);
		catmod.setCategory_status(status);
		session.update(catmod);
		tran.commit();
		session.close();		
	}
	
	@Override
	public String generateID() {
		String newID;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List templist = session.createQuery("from CategoryModel order by category_id desc").list();
		if(templist.size()==0)
		{
			newID="C001";	
		}
		else
		{
		CategoryModel Obj = (CategoryModel) templist.get(0);
		String id = Obj.getCategory_id();
		String temp = id.substring(0, 1);
		int tempID = Integer.parseInt(id.substring(1, 4));
		tempID++;
		newID = temp + String.format("%03d", tempID);
		}
		tran.commit();
		session.close();
		return newID;
	}
	
	@Override
	public String retrieveCategoriesByStatus() 
	{	
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Criteria criteria = session.createCriteria(CategoryModel.class);
		criteria.add(Restrictions.eq("category_status", "Enabled"));
		List licm = criteria.list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(licm);
		tran.commit();
		session.close();
		return jsonlist;
	}
}
