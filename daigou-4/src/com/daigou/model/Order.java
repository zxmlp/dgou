package com.daigou.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orders", catalog = "daigou")
public class Order implements java.io.Serializable {

	// Fields

	private Integer orderid;
	private Watch watch;
	private Goods goods;
	private Moms moms;
	private User user;
	private Gaoding gaoding;
	private Integer goodsnum;
	private Double total;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Watch watch, Goods goods, Moms moms, User user,
			Gaoding gaoding, Integer goodsnum, Double total) {
		this.watch = watch;
		this.goods = goods;
		this.moms = moms;
		this.user = user;
		this.gaoding = gaoding;
		this.goodsnum = goodsnum;
		this.total = total;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "orderid", unique = true, nullable = false)
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "watch")
	public Watch getWatch() {
		return this.watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "goods")
	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "moms")
	public Moms getMoms() {
		return this.moms;
	}

	public void setMoms(Moms moms) {
		this.moms = moms;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gaoding")
	public Gaoding getGaoding() {
		return this.gaoding;
	}

	public void setGaoding(Gaoding gaoding) {
		this.gaoding = gaoding;
	}

	@Column(name = "goodsnum")
	public Integer getGoodsnum() {
		return this.goodsnum;
	}

	public void setGoodsnum(Integer goodsnum) {
		this.goodsnum = goodsnum;
	}

	@Column(name = "total", precision = 22, scale = 0)
	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}