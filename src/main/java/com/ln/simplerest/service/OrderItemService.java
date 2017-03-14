package com.ln.simplerest.service;

import java.util.List;

import com.ln.simplerest.model.OrderItem;

public interface OrderItemService {

	/**
	 * 根据订单编号得到订单明细列表
	 * @param orderId
	 * @return
	 */
	List<OrderItem> listByOrderId(String orderId);
	
}
