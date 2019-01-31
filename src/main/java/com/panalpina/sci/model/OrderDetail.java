package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_Order_Details database table.
 * 
 */
@Entity
@Table(name="t_Order_Details")
@NamedQuery(name="OrderDetail.findAll", query="SELECT t FROM OrderDetail t")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Order_Detail_ID")
	private int orderDetailID;

	@Column(name="Line_Number")
	private String lineNumber;

	@Column(name="Order_Number")
	private String orderNumber;

	@Column(name="Product_Description")
	private String productDescription;

	@Column(name="Product_Type")
	private String productType;

	@Column(name="Qty")
	private int qty;

	@Column(name="Volume")
	private double volume;

	//bi-directional many-to-one association to T_Order
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Order_ID")
	private Order order;

	public OrderDetail() {
	}

	public int getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getVolume() {
		return this.volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}