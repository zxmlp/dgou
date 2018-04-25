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
 * Moms entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "moms", catalog = "daigou")
public class Moms implements java.io.Serializable {

	// Fields

	private Integer momsid;
	private String momsname;
	private Double mprice;
	private String mfilepath;
	private Set<Order> orders = new HashSet<Order>(0);
	private Set<Order> orders_1 = new HashSet<Order>(0);

	// Constructors

	/** default constructor */
	public Moms() {
	}

	/** minimal constructor */
	public Moms(String mfilepath) {
		this.mfilepath = mfilepath;
	}

	/** full constructor */
	public Moms(String momsname, Double mprice, String mfilepath,
			Set<Order> orders, Set<Order> orders_1) {
		this.momsname = momsname;
		this.mprice = mprice;
		this.mfilepath = mfilepath;
		this.orders = orders;
		this.orders_1 = orders_1;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "momsid", unique = true, nullable = false)
	public Integer getMomsid() {
		return this.momsid;
	}

	public void setMomsid(Integer momsid) {
		this.momsid = momsid;
	}

	@Column(name = "momsname", length = 40)
	public String getMomsname() {
		return this.momsname;
	}

	public void setMomsname(String momsname) {
		this.momsname = momsname;
	}

	@Column(name = "mprice", precision = 22, scale = 0)
	public Double getMprice() {
		return this.mprice;
	}

	public void setMprice(Double mprice) {
		this.mprice = mprice;
	}

	@Column(name = "mfilepath", nullable = false, length = 100)
	public String getMfilepath() {
		return this.mfilepath;
	}

	public void setMfilepath(String mfilepath) {
		this.mfilepath = mfilepath;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "moms")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "moms")
	public Set<Order> getOrders_1() {
		return this.orders_1;
	}

	public void setOrders_1(Set<Order> orders_1) {
		this.orders_1 = orders_1;
	}

}