package com.niit.giftsonline.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.niit.giftsonline.dao.UserDAO;
import com.niit.giftsonline.model.UserModel;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAOImpl()
	{
	}
	
	@Override
	public void addUser(UserModel um) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(um);
		tran.commit();
		session.close();
	}

	@Override
	public String retrieveUsers() 
	{	
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List lium = session.createQuery("from UserModel").list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(lium);
		tran.commit();
		session.close();
		return jsonlist;
	}

	@Override
	public UserModel fetchUserToUpdate(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		UserModel UserObject = (UserModel)session.get(UserModel.class, id);
		tran.commit();
		session.close();
		return UserObject;
	}

	@Override
	public void deleteUser(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		UserModel Userobj = (UserModel)session.get(UserModel.class, id);
		session.delete(Userobj);
		tran.commit();
		session.close();
	}

	@Override
	public void updateUser(UserModel usermod) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(usermod);
		tran.commit();
		session.close();		
	}
	
	@Override
	public void setUserStatus(String id, String status) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		UserModel usermod = (UserModel) session.get(UserModel.class,id);
		//usermod.setUser_status(status);
		session.update(usermod);
		tran.commit();
		session.close();		
	}
	
	@Override
	public long getTotalNumberOfUsers() {
		long total_users;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "select count(*) from UserModel";
		Query query = session.createQuery(hql);
		total_users = (long) query.uniqueResult();
		tran.commit();
		session.close();
		//logger.info("Count of users in daoimpl = "+ total_users);
		return total_users;
	}
}
