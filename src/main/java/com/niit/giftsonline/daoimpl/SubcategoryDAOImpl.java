package com.niit.giftsonline.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.niit.giftsonline.dao.SubcategoryDAO;
import com.niit.giftsonline.model.CategoryModel;
import com.niit.giftsonline.model.SubcategoryModel;

@Repository("subcategoryDAO")
public class SubcategoryDAOImpl implements SubcategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public SubcategoryDAOImpl()
	{	
	}

	@Override
	public void addSubcategory(SubcategoryModel scm) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(scm);
		tran.commit();
		session.close();
	}

	@Override
	public String retrieveSubcategories() 
	{	
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List liscm = session.createQuery("from SubcategoryModel").list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(liscm);
		tran.commit();
		session.close();
		return jsonlist;
	}

	@Override
	public SubcategoryModel fetchSubcategoryToUpdate(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		SubcategoryModel SubcategoryObject = (SubcategoryModel)session.get(SubcategoryModel.class, id);
		tran.commit();
		session.close();
		return SubcategoryObject;
	}

	@Override
	public void deleteSubcategory(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		SubcategoryModel subcategoryobj = (SubcategoryModel)session.get(SubcategoryModel.class, id);
		session.delete(subcategoryobj);
		tran.commit();
		session.close();
	}

	@Override
	public void updateSubcategory(SubcategoryModel subcatmod) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(subcatmod);
		tran.commit();
		session.close();		
	}
	
	@Override
	public void setSubcategoryStatus(String id, String status) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		SubcategoryModel subcatmod = (SubcategoryModel) session.get(SubcategoryModel.class,id);
		subcatmod.setSubcategory_status(status);
		session.update(subcatmod);
		tran.commit();
		session.close();		
	}
	
	@Override
	public String generateID() {
		String newID;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List templist = session.createQuery("from SubcategoryModel order by subcategory_id desc").list();
		if(templist.size()==0)
		{
			newID="SC001";	
		}
		else
		{
		SubcategoryModel Obj = (SubcategoryModel) templist.get(0);
		String id = Obj.getSubcategory_id();
		String temp = id.substring(0, 2);
		int tempID = Integer.parseInt(id.substring(2, 5));
		tempID++;
		newID = temp + String.format("%03d", tempID);
		}
		tran.commit();
		session.close();
		return newID;
	}
}
