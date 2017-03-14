package com.ln.simplerest.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.ibatis.session.SqlSessionManager;

import com.ln.simplerest.dao.OrderDao;
import com.ln.simplerest.exception.DaoException;
import com.ln.simplerest.mapper.OrderMapper;
import com.ln.simplerest.model.Order;

@Singleton
public class OrderDaoMapperImpl implements OrderDao {

	@Inject
	private SqlSessionManager sqlSessionManager;
	
	/**
	 * 得到所有订单
	 */
	public List<Order> listAllOrder() {
		try {
			return sqlSessionManager.getMapper(OrderMapper.class).listAllOrder();
		} catch(Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	/**
	 * 添加订单
	 */
	public void saveOrder(Order order) {
		try {
			//在Servcie中添加@Transactional注解，让事务拦截器管理连接。
			sqlSessionManager.getMapper(OrderMapper.class).saveOrder(order);
		}  catch(Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	/**
	 * 根据编号查询订单
	 * @param id
	 * @return
	 */
	public Order getById(String id) {
		try {
			return sqlSessionManager.getMapper(OrderMapper.class).getById(id);
		} catch(Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	/**
	 * 删除订单
	 * @param id
	 * @return
	 */
	public int removeOrder(String id) {
		try {
			//在Servcie中添加@Transactional注解，让事务拦截器管理连接。
			return sqlSessionManager.getMapper(OrderMapper.class).removeOrder(id);
		} catch(Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
}
