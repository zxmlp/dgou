package com.daigou.dao;

import java.util.ArrayList;



import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daigou.model.User;
import com.daigou.model.*;
import com.daigou.model.Order;


@Service @Transactional
public class OrderDao {
	@Resource SessionFactory factory;
	
	 /*���Order��Ϣ*/
    public void AddOrder(Order order) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(order);
    }
    
    /*ɾ��Order��Ϣ*/
    public void DeleteOrder (Integer orderid) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object order = s.load(Order.class, orderid);
        s.delete(order);
    }
    
    /*����Order��Ϣ*/
    public void UpdateOrder(Order order) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(order);
    }
    
    /*��ѯ����Order��Ϣ*/
    public ArrayList<Order> QueryAllOrder() {
        Session s = factory.getCurrentSession();
        String hql = "From Order";
        Query q = s.createQuery(hql);
        List orderList = q.list();
        return (ArrayList<Order>) orderList;
    }

    /*��������ȡ����*/
    public Order GetOrderById(Integer orderid) {
        Session s = factory.getCurrentSession();
        Order order = (Order)s.get(Order.class, orderid);
        return order;
    }
    
    /*��ݲ�ѯ������ѯ��һ����˵��������ѯʱ�������û�ID���Ӧ�Ķ�����������ʳ����Ʋ��Ӧ�Ķ���*/
    public ArrayList<Order> QueryOrderInfo(User user, Goods goods) {
    	Session s = factory.getCurrentSession();
    	String hql = "From Order order where 1=1";
    	if(null != user && user.getUserid()!=0) 
    		hql = hql + " and order.user.userid like '%" + user.getUserid() + "%'";
    	if(null != goods && null!=goods.getGoodsname()) 
    		hql = hql + " and order.goods.goodsname like '%" + goods.getGoodsname() + "%'";
    	Query q = s.createQuery(hql);
    	List orderList = q.list();
    	return (ArrayList<Order>) orderList;
    }
    
    public ArrayList<Order> QueryOrderInfo(User user, Gaoding gaoding) {
    	Session s = factory.getCurrentSession();
    	String hql = "From Order order where 1=1";
    	if(null != user && user.getUserid()!=0) 
    		hql = hql + " and order.user.userid like '%" + user.getUserid() + "%'";
    	if(null != gaoding && null!=gaoding.getGaoname()) 
    		hql = hql + " and order.gaoding.gaoname like '%" + gaoding.getGaoname() + "%'";
    	Query q = s.createQuery(hql);
    	List orderList = q.list();
    	return (ArrayList<Order>) orderList;
    }
    public ArrayList<Order> QueryOrderInfo(User user, Watch watch) {
    	Session s = factory.getCurrentSession();
    	String hql = "From Order order where 1=1";
    	if(null != user && user.getUserid()!=0) 
    		hql = hql + " and order.user.userid like '%" + user.getUserid() + "%'";
    	if(null != watch && null!=watch.getWatchname()) 
    		hql = hql + " and order.watch.watchname like '%" + watch.getWatchname() + "%'";
    	Query q = s.createQuery(hql);
    	List orderList = q.list();
    	return (ArrayList<Order>) orderList;
    }
    public ArrayList<Order> QueryOrderInfo(User user, Moms moms) {
    	Session s = factory.getCurrentSession();
    	String hql = "From Order order where 1=1";
    	if(null != user && user.getUserid()!=0) 
    		hql = hql + " and order.user.userid like '%" + user.getUserid() + "%'";
    	if(null != moms && null!=moms.getMomsname()) 
    		hql = hql + " and order.moms.momsname like '%" + moms.getMomsname() + "%'";
    	Query q = s.createQuery(hql);
    	List orderList = q.list();
    	return (ArrayList<Order>) orderList;
    }
    public ArrayList<Order> QueryOrderInfo(User user) {
    	Session s = factory.getCurrentSession();
    	String hql = "From Order order where 1=1";
    	if(null != user && user.getUserid()!=0) 
    		hql = hql + " and order.user.userid like '%" + user.getUserid() + "%'";
    	Query q = s.createQuery(hql);
    	List orderList = q.list();
    	return (ArrayList<Order>) orderList;
    }
}
