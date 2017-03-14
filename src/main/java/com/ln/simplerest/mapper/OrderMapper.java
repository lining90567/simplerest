package com.ln.simplerest.mapper;

import java.util.List;

import com.ln.simplerest.model.Order;

public interface OrderMapper {

	/**
	 * 得到所有订单
	 * @return
	 */
	List<Order> listAllOrder();
	
	/**
	 * 添加订单
	 * @param order
	 */
	void saveOrder(Order order);
	
	/**
	 * 根据编号查询订单
	 * @param id
	 * @return
	 */
	Order getById(String id);
	
	/**
	 * 删除订单
	 * @param id
	 * @return
	 */
	int removeOrder(String id);
	
}
