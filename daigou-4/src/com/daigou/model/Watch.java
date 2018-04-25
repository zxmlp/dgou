package com.daigou.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Watch entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "watch", catalog = "daigou")
public class Watch implements java.io.Serializable {

	// Fields

	private Integer watchid;
	private String watchname;
	private Double wprice;
	private String wfilepath;
	private Set<Order> orders = new HashSet<Order>(0);
	private Set<Order> orders_1 = new HashSet<Order>(0);

	// Constructors

	/** default constructor */
	public Watch() {
	}

	/** minimal constructor */
	public Watch(String wfilepath) {
		this.wfilepath = wfilepath;
	}

	/** full constructor */
	public Watch(String watchname, Double wprice, String wfilepath,
			Set<Order> orders, Set<Order> orders_1) {
		this.watchname = watchname;
		this.wprice = wprice;
		this.wfilepath = wfilepath;
		this.orders = orders;
		this.orders_1 = orders_1;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "watchid", unique = true, nullable = false)
	public Integer getWatchid() {
		return this.watchid;
	}

	public void setWatchid(Integer watchid) {
		this.watchid = watchid;
	}

	@Column(name = "watchname", length = 40)
	public String getWatchname() {
		return this.watchname;
	}

	public void setWatchname(String watchname) {
		this.watchname = watchname;
	}

	@Column(name = "wprice", precision = 22, scale = 0)
	public Double getWprice() {
		return this.wprice;
	}

	public void setWprice(Double wprice) {
		this.wprice = wprice;
	}

	@Column(name = "wfilepath", nullable = false, length = 100)
	public String getWfilepath() {
		return this.wfilepath;
	}

	public void setWfilepath(String wfilepath) {
		this.wfilepath = wfilepath;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "watch")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "watch")
	public Set<Order> getOrders_1() {
		return this.orders_1;
	}

	public void setOrders_1(Set<Order> orders_1) {
		this.orders_1 = orders_1;
	}

}