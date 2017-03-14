package com.ln.simplerest.service.impl;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.ln.simplerest.dao.OrderDao;
import com.ln.simplerest.dao.OrderItemDao;
import com.ln.simplerest.model.Order;
import com.ln.simplerest.model.OrderItem;
import com.ln.simplerest.service.OrderService;
import com.ln.simplerest.support.mybatis.transactional.Transactional;

@Singleton
public class OrderServiceImpl implements OrderService {
	
	@Inject
	private OrderDao orderDao;
	
	@Inject
	private OrderItemDao orderItemDao;

	/**
	 * 得到所有订单
	 */
	@Override
	public List<Order> listAllOrder() {
		return orderDao.listAllOrder();
	}
	
	/**
	 * 添加订单
	 * 需要添加sr_order和sr_order_item表的数据，所以需要添加事务注解。
	 */
	@Transactional
	public void saveOrder(Order order) {
		orderDao.saveOrder(order);
		for(OrderItem item : order.getItems()) {
			item.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			item.setOrder(new Order(order.getId()));
		}
		orderItemDao.saveOrderItems(order.getItems());
	}
	
	/**
	 * 根据编号查询订单
	 * @param id
	 * @return
	 */
	public Order getById(String id) {
		return orderDao.getById(id);
	}
	
	/**
	 * 删除订单
	 * @param id
	 * @return
	 * 需要删除sr_order和sr_order_item表的数据，所以需要添加事务注解。
	 */
	@Transactional
	public int removeOrder(String id) {
		//删除订单
		int rows = orderDao.removeOrder(id);
		//删除订单明细
		rows += orderItemDao.removeByOrderId(id);
		return rows;
	}

}
