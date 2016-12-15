package com.niit.giftsonline.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.niit.giftsonline.dao.CartDAO;
import com.niit.giftsonline.dao.OrderDAO;
import com.niit.giftsonline.model.CartModel;
import com.niit.giftsonline.model.OrderModel;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	OrderDAO orderdao;
	
	public CartDAOImpl()
	{
	}
	
	@Override
	public void addCart(CartModel cm) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		cm.setCart_id(this.generateID());
		/*productsincart.put(this.generateID(), cm);
		for (Map.Entry<String, CartModel> entry : productsincart.entrySet()) {
		     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().getProduct_name());
		}*/
		session.save(cm);
		tran.commit();
		session.close();
	}
	
	/* To retrive all carts for a user */
	@Override
	public String retrieveCarts(String username) 
	{	
		String jsonlist;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Criteria criteria = session.createCriteria(CartModel.class);
		criteria.add(Restrictions.eq("username", username));
		List lipm = criteria.list();
		//List lipm = session.createQuery("from CartModel").list();
		if(lipm.size()==0)
		{
			jsonlist = null;
		}
		else
		{	
			Gson gs = new Gson();
			jsonlist = gs.toJson(lipm);
		}
		tran.commit();
		session.close();
		return jsonlist;
	}

	@Override
	public void deleteCart(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		CartModel cartobj = (CartModel)session.get(CartModel.class, id);
		session.delete(cartobj);
		tran.commit();
		session.close();
	}

	@Override
	public void updateCart(String id, int quantity) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		CartModel cartobj = (CartModel)session.get(CartModel.class, id);
		cartobj.setQuantity(quantity);
		session.update(cartobj);
		tran.commit();
		session.close();		
	}
	
	@Override
	public String generateID() {
		String newID;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List templist = session.createQuery("from CartModel order by cart_id desc").list();
		if(templist.size()==0)
		{
			newID="Cart-001";	
		}
		else
		{
		CartModel Obj = (CartModel) templist.get(0);
		String id = Obj.getCart_id();
		String temp = id.substring(0, 5);
		int tempID = Integer.parseInt(id.substring(5, 8));
		tempID++;
		newID = temp + String.format("%03d", tempID);
		}
		tran.commit();
		session.close();
		return newID;
	}
	
	@Override
	public long getTotalPriceOfCart(String username) {
		long total_price;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "select sum(price*quantity) from CartModel where username = '"+username+"'";
		Query query = session.createQuery(hql);
		if(query.uniqueResult()==null)
		{
			total_price = 0;
		}
		else
		{	
			total_price = (long) query.uniqueResult();
		}
		tran.commit();
		session.close();
		return total_price;
	}
	
	@Override
	public long getTotalQuantityOfCart(String username) {
		long total_quantity;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "select sum(quantity) from CartModel where username = '"+username+"'";
		Query query = session.createQuery(hql);
		if(query.uniqueResult()==null)
		{
			total_quantity = 0;
		}
		else
		{	
			total_quantity = (long) query.uniqueResult();
		}
		tran.commit();
		session.close();
		return total_quantity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateCartsWithOrderId(String id) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		String orderid;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Criteria criteria1 = session.createCriteria(OrderModel.class);
		criteria1.add(Restrictions.eq("username", username));
		criteria1.addOrder(Order.desc("order_id"));
		List lioorder = criteria1.list();
		OrderModel Obj = (OrderModel) lioorder.get(0);
		orderid = Obj.getOrder_id();
		Criteria criteria2 = session.createCriteria(CartModel.class);
		criteria2.add(Restrictions.eq("username", username));
		List lioc = criteria2.list();
		for(Object object : lioc)
		{
			CartModel cartmod = (CartModel) object;
			cartmod.setCart_order_id(orderid);
			session.update(cartmod);
		}
		tran.commit();
		session.close();
	}
	
	@Override
	public String retriveCartsWithOrderId() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String orderid;
		Criteria criteria1 = session.createCriteria(OrderModel.class);
		criteria1.add(Restrictions.eq("username", username));
		criteria1.addOrder(Order.desc("order_id"));
		List lioorder = criteria1.list();
		OrderModel Obj = (OrderModel) lioorder.get(0);
		orderid = Obj.getOrder_id();
		Criteria criteria2 = session.createCriteria(CartModel.class);
		//criteria2.add(Restrictions.eq("username", username));
		criteria2.add(Restrictions.eq("cart_order_id", orderid));
		/*String hql = "Select cart_id, product_name, price from CartModel where username ='"+username+"' and cart_order_id ='"+orderid+"'";
		Query query = session.createQuery(hql); 
		List lioc = query.list();*/
		List lioc = criteria2.list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(lioc);
		tran.commit();
		session.close();
		return jsonlist;
	}
	
	@Override
	public void removeCartsWithOrderId() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String orderid;
		Criteria criteria1 = session.createCriteria(OrderModel.class);
		criteria1.add(Restrictions.eq("username", username));
		criteria1.addOrder(Order.desc("order_id"));
		List lioorder = criteria1.list();
		OrderModel Obj = (OrderModel) lioorder.get(0);
		orderid = Obj.getOrder_id();
		Criteria criteria2 = session.createCriteria(CartModel.class);
		//criteria2.add(Restrictions.eq("username", username));
		criteria2.add(Restrictions.eq("cart_order_id", orderid));
		/*String hql = "Select cart_id, product_name, price from CartModel where username ='"+username+"' and cart_order_id ='"+orderid+"'";
		Query query = session.createQuery(hql); 
		List lioc = query.list();*/
		List lioc = criteria2.list();
		for(Object object : lioc)
		{
			CartModel cartmod = (CartModel) object;
			session.delete(cartmod);
		}
		tran.commit();
		session.close();
	}
}
