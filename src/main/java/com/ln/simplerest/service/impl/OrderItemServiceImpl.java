package com.ln.simplerest.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.ln.simplerest.dao.OrderItemDao;
import com.ln.simplerest.model.OrderItem;
import com.ln.simplerest.service.OrderItemService;

@Singleton
public class OrderItemServiceImpl implements OrderItemService {
	
	@Inject
	private OrderItemDao orderItemDao;

	/**
	 * 根据订单编号得到订单明细列表
	 * @param orderId
	 * @return
	 */
	@Override
	public List<OrderItem> listByOrderId(String orderId) {
		return orderItemDao.listByOrderId(orderId);
	}

}
