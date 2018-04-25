package com.daigou.action;

import java.util.List;



import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.daigou.dao.GaodingDao;
import com.daigou.dao.MomsDao;
import com.daigou.dao.UserDao;
import com.daigou.dao.GoodsDao;
import com.daigou.dao.OrderDao;
import com.daigou.dao.WatchDao;
import com.daigou.model.*;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class OrderAction extends ActionSupport{
	
	 /*ҵ������*/
    @Resource OrderDao orderDao;
    @Resource UserDao userDao;
    @Resource GoodsDao goodsDao;
    @Resource GaodingDao gaodingDao;
    @Resource WatchDao watchDao;
    @Resource MomsDao momsDao;
    
    private Order order;
    private List<Order> orderList;
    private User user;
    private Goods goods;
    private Gaoding gao;
    private Watch watch;
    private Moms moms;
    
    
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	/*���Order*/
	public String addOrder() throws Exception{
		
		user = userDao.QueryUserInfo(user.getName()).get(0);
		Order ord =new Order();
		ord.setUser(user);
		if(goods!=null){
			ord.setGoods(goods);
			ord.setTotal(goodsDao.GetGoodsById(goods.getGoodsid()).getPrice()*1);
		}
		if(gao!=null){
			ord.setGaoding(gao);
			ord.setTotal(gaodingDao.GetGaoById(gao.getGaoid()).getGprice()*1);
		}
		if(moms!=null){
			ord.setMoms(moms);
			ord.setTotal(momsDao.GetMomsById(moms.getMomsid()).getMprice()*1);
		}
		if(watch!=null){
			ord.setWatch(watch);
			ord.setTotal(watchDao.GetWatchById(watch.getWatchid()).getWprice()*1);
		}
		ord.setGoodsnum(1);
		orderDao.AddOrder(ord);
		return "order_message";
		
	}
	
	/*��ʾ����Order*/
    public String showOrder() {
      System.out.println(user.getName());
        //��ϵͳ�趨Ϊ�û����ظ��������ϵͳ�в�ѯ����һ��������û�����
        User cus= userDao.QueryUserInfo(user.getName()).get(0);
        //ע�ⲻ��Ҫfood�Ĳ�ѯ����ʱ����������д����ֱ�ӽ�food��������Ϊnull
        orderList = orderDao.QueryOrderInfo(cus);
   
        return "show_view";
    }

    /*��ʾĳһOrder����ϸ��Ϣ*/
    public String showDetail() {
    	System.out.print(order.getOrderid());
    	order = orderDao.GetOrderById(order.getOrderid());
        return "detail_view";
    }
    
    /*��ʾOrder���޸���*/
    /*public String showEdit() throws Exception {
    	order = orderDao.GetOrderById(order.getOrderid());
        return "edit_view";
    }*/

    /*�༭Order*/
    /*public String editOrder() throws Exception {
    	orderDao.UpdateOrder(order);
        return "edit_message";
    }*/
    
    /*ɾ��Order*/
    /*public String deleteOrder() throws Exception {
    	orderDao.DeleteOrder(food.getFoodid());
        return "delete_message";
    }*/
    
    /*��ѯOrder*/
    public String queryOrders() throws Exception {
    	orderList = orderDao.QueryOrderInfo(user,goods);
    	
    	return "show_view";
    }

	public Gaoding getGao() {
		return gao;
	}

	public void setGao(Gaoding gao) {
		this.gao = gao;
	}

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public Moms getMoms() {
		return moms;
	}

	public void setMoms(Moms moms) {
		this.moms = moms;
	}


}
