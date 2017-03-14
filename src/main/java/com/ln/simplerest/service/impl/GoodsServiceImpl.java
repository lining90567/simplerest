package com.ln.simplerest.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.ln.simplerest.dao.GoodsDao;
import com.ln.simplerest.model.Goods;
import com.ln.simplerest.service.GoodsService;
import com.ln.simplerest.support.mybatis.data.Page;

@Singleton
public class GoodsServiceImpl implements GoodsService {
	
	@Inject
	private GoodsDao goodsDao;

	/**
	 * 得到所有货品
	 * @return
	 */
	@Override
	public List<Goods> listAllGoods() {
		return goodsDao.listAllGoods();
	}
	
	/**
	 * 根据货品编号得到货品
	 * @param id 货品Id
	 * @return
	 */
	public Goods getById(String id) {
		return goodsDao.getById(id);
	}
	
	/**
	 * 添加货品
	 * @param goods
	 * @return
	 */
	public void saveGoods(Goods goods) {
		goodsDao.saveGoods(goods);
	}
	
	/**
	 * 分页查询货品
	 * @param pageIndex 页号
	 * @param pageSize 每页显示的记录数
	 * @param name 货品名称 
	 * @param order 排序
	 * @return
	 */
	public Page<Goods> listPagedGoods(int pageIndex, int pageSize, String name, String order) {
		return goodsDao.listPagedGoods(pageIndex, pageSize, name, order);
	}
	
	/**
	 * 修改货品
	 * @param goods
	 * @return
	 */
	public int updateGoods(Goods goods) {
		return goodsDao.updateGoods(goods);
	}
	
	/**
	 * 删除货品
	 * @param id
	 * @return
	 */
	public int removeGoods(String id) {
		return goodsDao.removeGoods(id);
	}

}
