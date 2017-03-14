package com.ln.simplerest.mapper;

import java.util.List;

import com.ln.simplerest.model.Goods;
import com.ln.simplerest.support.mybatis.data.PageRequest;

public interface GoodsMapper {

	/**
	 * 得到所有货品
	 * @return
	 */
	List<Goods> listAllGoods();
	
	/**
	 * 根据货品编号得到货品
	 * @param id 货品Id
	 * @return
	 */
	Goods getById(String id);
	
	/**
	 * 添加货品
	 * @param goods
	 */
	void saveGoods(Goods goods);
	
	/**
	 * 统计货品数量
	 * @param pageRequest 分页查询请求
	 * @return
	 */
	int countGoods(PageRequest pageRequest);
	
	/**
	 * 分页查询货品
	 * @param pageRequest 分页查询请求
	 * @return
	 */
	List<Goods> listPagedGoods(PageRequest pageRequest);
	
	/**
	 * 修改货品
	 * @param goods
	 * @return
	 */
	int updateGoods(Goods goods);
	
	/**
	 * 删除货品
	 * @param id
	 * @return
	 */
	int removeGoods(String id);
	
}
