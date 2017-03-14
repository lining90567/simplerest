package com.ln.simplerest.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.ibatis.session.SqlSessionManager;

import com.ln.simplerest.dao.GoodsDao;
import com.ln.simplerest.exception.DaoException;
import com.ln.simplerest.mapper.GoodsMapper;
import com.ln.simplerest.model.Goods;
import com.ln.simplerest.support.mybatis.data.Page;
import com.ln.simplerest.support.mybatis.data.PageRequest;

@Singleton
public class GoodsDaoMapperImpl implements GoodsDao {

	@Inject
	private SqlSessionManager sqlSessionManager;

	/**
	 * 得到所有货品
	 * 
	 * @return
	 */
	public List<Goods> listAllGoods() {
		try {
			return sqlSessionManager.getMapper(GoodsMapper.class).listAllGoods();
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}
	
	/**
	 * 根据货品编号得到货品
	 * @param id 货品Id
	 * @return
	 */
	public Goods getById(String id) {
		try {
			return sqlSessionManager.getMapper(GoodsMapper.class).getById(id);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}
	
	/**
	 * 添加货品
	 */
	public void saveGoods(Goods goods) {
		try {
			sqlSessionManager.getMapper(GoodsMapper.class).saveGoods(goods);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}
	
	/**
	 * 分页查询货品
	 * @param pageIndex 页码
	 * @param pageSize 每页显示的记录数
	 * @param name 货品名称
	 * @param order 排序
	 * @return
	 */
	public Page<Goods> listPagedGoods(int pageIndex, int pageSize, String name, String order) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(name != null && !name.trim().equals("")) {
			map.put("goodsName", name);
		}
		PageRequest pageRequest = new PageRequest(pageIndex, pageSize, map, order);
		//先查询符合条件的记录数
		int total = sqlSessionManager.getMapper(GoodsMapper.class).countGoods(pageRequest);
		List<Goods> goodsList = null;
		//记录数>0，则继续查询
		if(total > 0) {
			goodsList = sqlSessionManager.getMapper(GoodsMapper.class).listPagedGoods(pageRequest);
		}
		return new Page<Goods>(total, goodsList);
	}
	
	/**
	 * 修改货品
	 * @param goods
	 * @return
	 */
	public int updateGoods(Goods goods) {
		try {
			return sqlSessionManager.getMapper(GoodsMapper.class).updateGoods(goods);			
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}
	
	/**
	 * 删除货品
	 * @param id
	 * @return
	 */
	public int removeGoods(String id) {
		try {
			return sqlSessionManager.getMapper(GoodsMapper.class).removeGoods(id);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

}
