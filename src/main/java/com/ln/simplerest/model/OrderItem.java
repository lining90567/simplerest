package com.ln.simplerest.model;

public class OrderItem {

	private String id;
	private Order order;
	private Goods goods;
	private double quantity;
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Order getOrder() {
		return this.order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Goods getGoods() {
		return this.goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	public double getQuantity() {
		return this.quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
}
