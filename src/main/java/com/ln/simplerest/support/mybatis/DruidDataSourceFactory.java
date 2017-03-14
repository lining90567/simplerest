package com.ln.simplerest.support.mybatis;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Druid数据源工厂类
 * @author ln
 *
 */
public class DruidDataSourceFactory extends UnpooledDataSourceFactory {

	public DruidDataSourceFactory() {
		this.dataSource = new DruidDataSource();
	}
	
}
