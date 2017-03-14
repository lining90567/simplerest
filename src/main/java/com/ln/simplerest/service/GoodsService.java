package com.ln.simplerest.service;

import java.util.List;

import com.ln.simplerest.model.Goods;
import com.ln.simplerest.support.mybatis.data.Page;

/**
 * 货品管理服务接口
 * 
 * @author ln
 *
 */
public interface GoodsService {

	/**
	 * 得到所有货品
	 * 
	 * @return goods list
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
	 * 分页查询货品
	 * @param pageIndex 页号
	 * @param pageSize 每页显示的记录数
	 * @param name 货品名称 
	 * @param order 排序
	 * @return
	 */
	Page<Goods> listPagedGoods(int pageIndex, int pageSize, String name, String order);
	
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
