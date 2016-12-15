package com.niit.giftsonline.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.niit.giftsonline.dao.UserCredentialDAO;
import com.niit.giftsonline.dao.UserDAO;
import com.niit.giftsonline.model.ProductModel;
import com.niit.giftsonline.model.UserCredentialModel;
import com.niit.giftsonline.model.UserModel;

@Repository("userCredentialDAO")
public class UserCredentialDAOImpl implements UserCredentialDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public UserCredentialDAOImpl()
	{
	}
	
	@Override
	public void addUserCredential(UserCredentialModel ucm) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(ucm);
		tran.commit();
		session.close();
	}

	@Override
	public String retrieveUserCredentials() 
	{	
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List liucm = session.createQuery("from UserCredentialModel").list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(liucm);
		tran.commit();
		session.close();
		return jsonlist;
	}
	
	@Override
	public UserCredentialModel fetchUserCredToUpdate(String username) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		UserCredentialModel usercredobject = (UserCredentialModel)session.get(UserCredentialModel.class, username);
		tran.commit();
		session.close();
		return usercredobject;
	}
	
	@Override
	public void updateUserCredentials(UserCredentialModel usercredmod) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(usercredmod);
		tran.commit();
		session.close();		
	}
	
	@Override
	public void setUserCredStatus(String username, boolean status) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		UserCredentialModel usercredmod = (UserCredentialModel) session.get(UserCredentialModel.class,username);
		usercredmod.setEnabled(status);
		session.update(usercredmod);
		tran.commit();
		session.close();		
	}
	
	@Override
	public long getTotalNumberOfActiveUsers() {
		long total_activeusers;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Criteria criteria = session.createCriteria(UserCredentialModel.class);
		criteria.add(Restrictions.eq("role", "ROLE_USER"));
		criteria.add(Restrictions.eq("enabled", true));
		criteria.setProjection(Projections.rowCount());
		total_activeusers = (long) criteria.uniqueResult();
		tran.commit();
		session.close();
		//logger.info("Count of users in daoimpl = "+ total_users);
		return total_activeusers;
	}

	/*@Override
	public void deleteUser(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		UserModel Userobj = (UserModel)session.get(UserModel.class, id);
		session.delete(Userobj);
		tran.commit();
		session.close();
	}
	
	
	
	@Override
	public String generateID() {
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
		return newID;
	}*/
}
