package com.ln.simplerest.model;

/**
 * 商品信息类
 * @author ln
 *
 */
public class Goods {

	private String id;
	private String name;
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String goodsName) {
		this.name = goodsName;
	}
	
}
