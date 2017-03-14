package com.ln.simplerest.mapper;

import java.util.List;

import com.ln.simplerest.model.OrderItem;

public interface OrderItemMapper {

	/**
	 * 根据订单编号得到订单明细列表
	 * @param orderId
	 * @return
	 */
	List<OrderItem> listByOrderId(String orderId);
	
	/**
	 * 添加订单明细
	 * @param items
	 */
	void saveOrderItems(List<OrderItem> items);
	
	/**
	 * 根据订单编号删除订单明细
	 * @param orderId
	 * @return
	 */
	int removeByOrderId(String orderId);
	
}
