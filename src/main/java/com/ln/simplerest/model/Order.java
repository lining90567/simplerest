package com.ln.simplerest.model;

import java.util.Date;
import java.util.List;

/**
 * 订单信息类
 * @author ln
 *
 */
public class Order {

	private String id;
	private Date date;
	private List<OrderItem> items;
	
	public Order() {
		
	}
	
	public Order(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date orderDate) {
		this.date = orderDate;
	}
	
	public List<OrderItem> getItems() {
		return this.items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
}
