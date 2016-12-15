package com.niit.giftsonline.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.niit.giftsonline.dao.SupplierDAO;
import com.niit.giftsonline.model.SubcategoryModel;
import com.niit.giftsonline.model.SupplierModel;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDAOImpl()
	{
	}
	
	@Override
	public void addSupplier(SupplierModel sm) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(sm);
		tran.commit();
		session.close();
	}

	@Override
	public String retrieveSuppliers() 
	{	
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List lipm = session.createQuery("from SupplierModel").list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(lipm);
		tran.commit();
		session.close();
		return jsonlist;
	}

	@Override
	public SupplierModel fetchSupplierToUpdate(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		SupplierModel SupplierObject = (SupplierModel)session.get(SupplierModel.class, id);
		tran.commit();
		session.close();
		return SupplierObject;
	}

	@Override
	public void deleteSupplier(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		SupplierModel supplierobj = (SupplierModel)session.get(SupplierModel.class, id);
		session.delete(supplierobj);
		tran.commit();
		session.close();
	}

	@Override
	public void updateSupplier(SupplierModel supmod) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(supmod);
		tran.commit();
		session.close();		
	}
	
	@Override
	public String generateID() {
		String newID;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List templist = session.createQuery("from SupplierModel order by supplier_id desc").list();
		if(templist.size()==0)
		{
			newID="S001";	
		}
		else
		{
		SupplierModel Obj = (SupplierModel) templist.get(0);
		String id = Obj.getSupplier_id();
		String temp = id.substring(0, 1);
		int tempID = Integer.parseInt(id.substring(1, 4));
		tempID++;
		newID = temp + String.format("%03d", tempID);
		}
		tran.commit();
		session.close();
		return newID;
	}
}
