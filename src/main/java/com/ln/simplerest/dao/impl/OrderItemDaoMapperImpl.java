package com.ln.simplerest.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.ibatis.session.SqlSessionManager;

import com.ln.simplerest.dao.OrderItemDao;
import com.ln.simplerest.exception.DaoException;
import com.ln.simplerest.mapper.OrderItemMapper;
import com.ln.simplerest.model.OrderItem;

@Singleton
public class OrderItemDaoMapperImpl implements OrderItemDao {

	@Inject
	private SqlSessionManager sqlSessionManager;

	/**
	 * 根据订单编号得到订单明细列表
	 * 
	 * @param orderId
	 * @return
	 */
	@Override
	public List<OrderItem> listByOrderId(String orderId) {
		try {
			return sqlSessionManager.getMapper(OrderItemMapper.class).listByOrderId(orderId);
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}

	/**
	 * 添加订单明细
	 * 
	 * @param items
	 */
	@Override
	public void saveOrderItems(List<OrderItem> items) {
		try {
			// 在Servcie中添加@Transactional注解，让事务拦截器管理连接。
			sqlSessionManager.getMapper(OrderItemMapper.class).saveOrderItems(items);
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	/**
	 * 根据订单编号删除订单明细
	 * @param orderId
	 * @return
	 */
	public int removeByOrderId(String orderId) {
		try {
			// 在Servcie中添加@Transactional注解，让事务拦截器管理连接。
			return sqlSessionManager.getMapper(OrderItemMapper.class).removeByOrderId(orderId);
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}

}
