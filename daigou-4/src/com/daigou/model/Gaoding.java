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
 * Gaoding entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gaoding", catalog = "daigou")
public class Gaoding implements java.io.Serializable {

	// Fields

	private Integer gaoid;
	private String gaoname;
	private Double gprice;
	private String gfilepath;
	private Set<Order> orders = new HashSet<Order>(0);
	private Set<Order> orders_1 = new HashSet<Order>(0);

	// Constructors

	/** default constructor */
	public Gaoding() {
	}

	/** minimal constructor */
	public Gaoding(String gfilepath) {
		this.gfilepath = gfilepath;
	}

	/** full constructor */
	public Gaoding(String gaoname, Double gprice, String gfilepath,
			Set<Order> orders, Set<Order> orders_1) {
		this.gaoname = gaoname;
		this.gprice = gprice;
		this.gfilepath = gfilepath;
		this.orders = orders;
		this.orders_1 = orders_1;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "gaoid", unique = true, nullable = false)
	public Integer getGaoid() {
		return this.gaoid;
	}

	public void setGaoid(Integer gaoid) {
		this.gaoid = gaoid;
	}

	@Column(name = "gaoname", length = 40)
	public String getGaoname() {
		return this.gaoname;
	}

	public void setGaoname(String gaoname) {
		this.gaoname = gaoname;
	}

	@Column(name = "gprice", precision = 22, scale = 0)
	public Double getGprice() {
		return this.gprice;
	}

	public void setGprice(Double gprice) {
		this.gprice = gprice;
	}

	@Column(name = "gfilepath", nullable = false, length = 100)
	public String getGfilepath() {
		return this.gfilepath;
	}

	public void setGfilepath(String gfilepath) {
		this.gfilepath = gfilepath;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "gaoding")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "gaoding")
	public Set<Order> getOrders_1() {
		return this.orders_1;
	}

	public void setOrders_1(Set<Order> orders_1) {
		this.orders_1 = orders_1;
	}

}