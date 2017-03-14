package com.ln.simplerest.support.guice;

import com.google.inject.AbstractModule;
import com.ln.simplerest.dao.GoodsDao;
import com.ln.simplerest.dao.OrderDao;
import com.ln.simplerest.dao.OrderItemDao;
import com.ln.simplerest.dao.impl.GoodsDaoMapperImpl;
import com.ln.simplerest.dao.impl.OrderDaoMapperImpl;
import com.ln.simplerest.dao.impl.OrderItemDaoMapperImpl;
import com.ln.simplerest.service.GoodsService;
import com.ln.simplerest.service.OrderItemService;
import com.ln.simplerest.service.OrderService;
import com.ln.simplerest.service.impl.GoodsServiceImpl;
import com.ln.simplerest.service.impl.OrderItemServiceImpl;
import com.ln.simplerest.service.impl.OrderServiceImpl;

/**
 * 引用模块，用来绑定dao和service
 * @author ln
 *
 */
public class AppModule extends AbstractModule {

	@Override
	protected void configure() {
		//绑定dao与service
		bind(GoodsDao.class).to(GoodsDaoMapperImpl.class);
    	bind(GoodsService.class).to(GoodsServiceImpl.class);
    	
    	bind(OrderDao.class).to(OrderDaoMapperImpl.class);
    	bind(OrderService.class).to(OrderServiceImpl.class);
    	
    	bind(OrderItemDao.class).to(OrderItemDaoMapperImpl.class);
    	bind(OrderItemService.class).to(OrderItemServiceImpl.class);
	}

}
