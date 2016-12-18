package com.niit.giftsonline.daoimpl;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.id.UUIDGenerationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.niit.giftsonline.dao.CartDAO;
import com.niit.giftsonline.dao.OrderDAO;
import com.niit.giftsonline.model.CartModel;
import com.niit.giftsonline.model.OrderModel;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {

	public static Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CartDAO cartdao;
	
	public OrderDAOImpl() {
		
	}

	@Override
	public void addOrderInDB(OrderModel ordermodel) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String id = this.generateID();
		ordermodel.setOrder_id(id);
		ordermodel.setUsername(username);
		ordermodel.setTotal_price((int) cartdao.getTotalPriceOfCart(username));
		session.save(ordermodel);
		tran.commit();
		session.close();
		cartdao.updateCartsWithOrderId(id);
	}

	@Override
	public String generateID() {
		logger.debug("Start of generateID method of Order");
		String newID;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List templist = session.createQuery("from OrderModel order by order_id desc").list();
		if(templist.size()==0)
		{
			newID="Order-001";	
		}
		else
		{
		OrderModel Obj = (OrderModel) templist.get(0);
		String id = Obj.getOrder_id();
		String temp = id.substring(0, 6);
		int tempID = Integer.parseInt(id.substring(6, 9));
		tempID++;
		newID = temp + String.format("%03d", tempID);
		}
		tran.commit();
		session.close();
		logger.debug("End of generateID method of Order");
		return newID;
	}
	
	@Override
	public long getTotalNumberOfOrders() {
		long total_orders;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "select count(*) from OrderModel";
		Query query = session.createQuery(hql);
		total_orders = (long) query.uniqueResult();
		tran.commit();
		session.close();
		//logger.info("Count of users in daoimpl = "+ total_users);
		return total_orders;
	}
	
	@Override
	public String retriveAllOrders() {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List liaorders = session.createQuery("From OrderModel").list();
		Gson gson = new Gson();
		String jsonlist = gson.toJson(liaorders);
		tran.commit();
		session.close();
		return jsonlist;
	}
	
	@Override
	public String retriveAllOrdersByUsername(String username) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String jsonlist;
		Criteria criteria = session.createCriteria(OrderModel.class);
		criteria.add(Restrictions.eq("username", username));
		List liaorders = criteria.list();
		if(liaorders.size()==0)
		{
			jsonlist = null;
		}
		else
		{	
			Gson gson = new Gson();
			jsonlist = gson.toJson(liaorders);
		}
		tran.commit();
		session.close();
		return jsonlist;
	}
	
	@Override
	public void updateOrderDate(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		OrderModel orderobj = (OrderModel) session.get(OrderModel.class, id);
		java.util.Date utilDate = new java.util.Date();
		Date date = new Date(utilDate.getTime());
		orderobj.setDate_processed(date);
		session.update(orderobj);
		tran.commit();
		session.close();
	}
}
